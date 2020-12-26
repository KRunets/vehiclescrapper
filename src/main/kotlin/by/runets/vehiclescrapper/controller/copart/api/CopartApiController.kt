package by.runets.vehiclescrapper.controller.copart.api

import by.runets.vehiclescrapper.controller.copart.data.mapper.impl.VehicleDtoToVehicleMapper
import by.runets.vehiclescrapper.controller.copart.data.parser.impl.JsonToTotalElementsParser
import by.runets.vehiclescrapper.controller.copart.data.parser.impl.JsonToVehicleDTOParser
import by.runets.vehiclescrapper.persistence.service.lookup.VehicleService
import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils
import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils.Companion.FIRST_VEHICLE
import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils.Companion.LOTS_SEARCH
import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils.Companion.MAKE_KEY
import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils.Companion.SIZE_KEY
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
                          @Autowired private val vehicleDtoToVehicleMapper: VehicleDtoToVehicleMapper,
                          @Autowired private val jsonToVehicleDtoParser: JsonToVehicleDTOParser,
                          @Autowired private val responseEntityToTotalElementsParser: JsonToTotalElementsParser) {

    @PostMapping("/lots/search/{make}/all")
    suspend fun searchAll(@PathVariable make : String) : Mono<ResponseEntity.BodyBuilder> {
        val totalElements = requestTotalElements(make)
        val vehiclesResponseEntity = requestVehicles(make, totalElements)
        val vehicleDtos = jsonToVehicleDtoParser.parse(vehiclesResponseEntity)
        val vehicles = vehicleDtoToVehicleMapper.map(vehicleDtos)
        vehicleService.saveAll(vehicles)
        return Mono.just(ResponseEntity.ok())
    }

    @PostMapping("/lots/search/{make}/{limit}")
    suspend fun search(@PathVariable make : String, @PathVariable limit : String) : Mono<ResponseEntity.BodyBuilder> {
        val vehiclesResponseEntity = requestVehicles(make, limit)
        val vehicleDtos = jsonToVehicleDtoParser.parse(vehiclesResponseEntity)
        val vehicles = vehicleDtoToVehicleMapper.map(vehicleDtos)
        vehicleService.saveAll(vehicles)
        return Mono.just(ResponseEntity.ok())
    }

    private fun requestVehicles(make: String, limit : String) : ResponseEntity<String> {
        return restTemplate.exchange(LOTS_SEARCH, HttpMethod.POST,
                HttpEntity(HttpUtils.BODY
                        .replace(MAKE_KEY, make.toUpperCase())
                        .replace(SIZE_KEY, limit), headers),
                String::class.java)

    }

    private fun requestTotalElements(make : String): String {
        val payloadBody = HttpUtils.BODY
                .replace(SIZE_KEY, FIRST_VEHICLE)
                .replace(MAKE_KEY, make.toUpperCase())

        val totalElementsResponseEntity: ResponseEntity<String> = restTemplate.exchange(LOTS_SEARCH, HttpMethod.POST,
                HttpEntity(payloadBody, headers), String::class.java)

        return responseEntityToTotalElementsParser.parse(totalElementsResponseEntity)
    }
}