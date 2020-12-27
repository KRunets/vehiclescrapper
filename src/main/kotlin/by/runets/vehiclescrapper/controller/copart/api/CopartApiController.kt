package by.runets.vehiclescrapper.controller.copart.api

import by.runets.vehiclescrapper.controller.copart.data.mapper.impl.VehicleDtoToVehicleMapper
import by.runets.vehiclescrapper.controller.copart.data.parser.impl.JsonLotToVehicleDTOParser
import by.runets.vehiclescrapper.controller.copart.data.parser.impl.JsonToTotalElementsParser
import by.runets.vehiclescrapper.controller.copart.data.parser.impl.JsonToVehicleDTOParser
import by.runets.vehiclescrapper.persistence.domain.Vehicle
import by.runets.vehiclescrapper.persistence.service.lookup.VehicleService
import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils
import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils.Companion.FIRST_VEHICLE
import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils.Companion.LOTS_SEARCH
import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils.Companion.LOT_NUMBER
import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils.Companion.LOT_SEARCH
import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils.Companion.MAKE_KEY
import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils.Companion.SIZE_KEY
import org.apache.commons.lang3.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/copart/api")
class CopartApiController(@Autowired private val restTemplate: RestTemplate,
                          @Autowired private val headers: HttpHeaders,
                          @Autowired private val vehicleService: VehicleService,
                          @Autowired private val jsonParsers : Map<String, Any>,
                          @Autowired private val vehicleDtoToVehicleMapper: VehicleDtoToVehicleMapper) {

    @PostMapping("/lots/search/{make}/all")
    suspend fun searchAll(@PathVariable make : String) : Mono<ResponseEntity.BodyBuilder> {
        val totalElements = requestTotalElements(make)
        val vehicles = requestVehiclesByMake(make, totalElements)
        vehicleService.saveAll(vehicles)
        return Mono.just(ResponseEntity.ok())
    }

    @PostMapping("/lots/search/{make}/{limit}")
    suspend fun search(@PathVariable make : String, @PathVariable limit : String) : Mono<ResponseEntity.BodyBuilder> {
        val vehicles = requestVehiclesByMake(make, limit)
        vehicleService.saveAll(vehicles)
        return Mono.just(ResponseEntity.ok())
    }

    @GetMapping("/lot/{lotNumber}")
    suspend fun loadVehicleByLotNumber(@PathVariable lotNumber : String) : Mono<ResponseEntity.BodyBuilder>  {
        val vehicle = requestLotByLotNumber(lotNumber)
        vehicleService.updateVehicleDynamicDetails(vehicle)
        return Mono.just(ResponseEntity.ok())
    }

    private fun requestVehiclesByMake(make: String, limit : String) : Set<Vehicle> {
        val vehiclesResponseEntity = restTemplate.exchange(LOTS_SEARCH, HttpMethod.POST,
                HttpEntity(HttpUtils.BODY
                        .replace(MAKE_KEY, make.toUpperCase())
                        .replace(SIZE_KEY, limit), headers),
                String::class.java)
        val jsonToVehicleDtoParser = jsonParsers[JsonToVehicleDTOParser::class.java.simpleName] as JsonToVehicleDTOParser
        val vehicleDtos = jsonToVehicleDtoParser.parse(vehiclesResponseEntity)
        return vehicleDtoToVehicleMapper.mapAll(vehicleDtos)
    }

    private fun requestLotByLotNumber(lotNumber : String) : Vehicle {
        val responseEntity: ResponseEntity<String> = restTemplate.exchange(LOT_SEARCH.replace(LOT_NUMBER, lotNumber),
                HttpMethod.GET,
                HttpEntity(StringUtils.EMPTY, headers),
                String::class.java)
        val jsonLotToVehicleDTOParser = jsonParsers[JsonLotToVehicleDTOParser::class.java.simpleName] as JsonLotToVehicleDTOParser
        val vehicleDto = jsonLotToVehicleDTOParser.parse(responseEntity)
        return vehicleDtoToVehicleMapper.map(vehicleDto)
    }

    private fun requestTotalElements(make : String): String {
        val payloadBody = HttpUtils.BODY
                .replace(SIZE_KEY, FIRST_VEHICLE)
                .replace(MAKE_KEY, make.toUpperCase())

        val totalElementsResponseEntity: ResponseEntity<String> = restTemplate.exchange(LOTS_SEARCH, HttpMethod.POST,
                HttpEntity(payloadBody, headers), String::class.java)

        val responseEntityToTotalElementsParser = jsonParsers[JsonToTotalElementsParser::class.java.simpleName] as JsonToTotalElementsParser
        return responseEntityToTotalElementsParser.parse(totalElementsResponseEntity)
    }
}