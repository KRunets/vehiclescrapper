package by.runets.vehiclescrapper.controller.copart.data.parser.impl

import by.runets.vehiclescrapper.controller.copart.dto.VehicleDto
import by.runets.vehiclescrapper.controller.copart.data.parser.IParser
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class JsonToVehicleDTOParser(@Autowired private val objectMapper : ObjectMapper) : IParser<ResponseEntity<String>, Set<VehicleDto>> {
    override fun parse(vehiclesResponseEntity: ResponseEntity<String>): Set<VehicleDto> {
        val rootJsonNode: JsonNode = objectMapper.readValue(vehiclesResponseEntity.body, JsonNode::class.java)
        val vehiclesJsonNode = rootJsonNode.get("data").get("results").get("content")
        val vehicles = HashSet<VehicleDto>()
        vehiclesJsonNode.forEach{ vjn ->
            run {
                val value = objectMapper.readValue(vjn.toString(), object : TypeReference<VehicleDto>() {})
                vehicles.add(value)
            }
        }
        return vehicles
    }
}