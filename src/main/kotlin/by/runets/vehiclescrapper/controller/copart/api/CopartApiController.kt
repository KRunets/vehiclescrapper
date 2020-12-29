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
import kotlinx.coroutines.reactive.awaitLast
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitExchange
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/copart/api/v2")
class CopartApiController(@Autowired private val webClient: WebClient,
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
        vehicleService.save(vehicle)
        return Mono.just(ResponseEntity.ok())
    }

    private suspend fun requestVehiclesByMake(make: String, limit : String) : Set<Vehicle> {
        val vehiclesResponseEntity = webClient
                .post()
                .uri(LOTS_SEARCH)
                .body(BodyInserters.fromValue(HttpUtils.BODY
                        .replace(MAKE_KEY, make.toUpperCase())
                        .replace(SIZE_KEY, limit)))
                .headers { headers }
                .accept(MediaType.APPLICATION_JSON)
                .awaitExchange()
                .toEntity(String::class.java)
                .awaitLast()
        val jsonToVehicleDtoParser = jsonParsers[JsonToVehicleDTOParser::class.java.simpleName] as JsonToVehicleDTOParser
        val vehicleDtos = jsonToVehicleDtoParser.parse(vehiclesResponseEntity)
        return vehicleDtoToVehicleMapper.mapAll(vehicleDtos)
    }

    private suspend fun requestLotByLotNumber(lotNumber : String) : Vehicle {
        val responseEntity = webClient
                .get()
                .uri(LOT_SEARCH.replace(LOT_NUMBER, lotNumber))
                .headers { h -> run { h.addAll(headers) } }
                .awaitExchange()
                .toEntity(String::class.java)
                .awaitLast()
        val jsonLotToVehicleDTOParser = jsonParsers[JsonLotToVehicleDTOParser::class.java.simpleName] as JsonLotToVehicleDTOParser
        val vehicleDto = jsonLotToVehicleDTOParser.parse(responseEntity)
        return vehicleDtoToVehicleMapper.map(vehicleDto)
    }

    private suspend fun requestTotalElements(make : String): String {
        val totalElementsResponseEntity = webClient
                .post()
                .uri(LOTS_SEARCH)
                .body(BodyInserters.fromValue(HttpUtils.BODY
                        .replace(SIZE_KEY, FIRST_VEHICLE)
                        .replace(MAKE_KEY, make.toUpperCase())))
                .headers { headers }
                .accept(MediaType.APPLICATION_JSON)
                .awaitExchange()
                .toEntity(String::class.java)
                .awaitLast()

        val responseEntityToTotalElementsParser = jsonParsers[JsonToTotalElementsParser::class.java.simpleName] as JsonToTotalElementsParser
        return responseEntityToTotalElementsParser.parse(totalElementsResponseEntity)
    }
}