package by.runets.vehiclescrapper.controller.copart.data.parser.impl

import by.runets.vehiclescrapper.controller.copart.dto.VehicleDto
import by.runets.vehiclescrapper.controller.copart.data.parser.IParser
import by.runets.vehiclescrapper.controller.copart.dto.DynamicLotDetailsDto
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

class JsonLotToVehicleDTOParser(private val objectMapper : ObjectMapper) : IParser<ResponseEntity<String>, VehicleDto> {
    override fun parse(vehiclesResponseEntity: ResponseEntity<String>): VehicleDto {
        val rootJsonNode: JsonNode = objectMapper.readValue(vehiclesResponseEntity.body, JsonNode::class.java)
        val vehiclesJsonNode = rootJsonNode.get("data").get("lotDetails")
        val vehicleDto = objectMapper.readValue(vehiclesJsonNode.toString(), object : TypeReference<VehicleDto>() {})
        val dynamicLotDetailsNode = rootJsonNode.get("data").get("lotDetails").get("dynamicLotDetails")
        val dynamicLotDto = objectMapper.readValue(dynamicLotDetailsNode.toString(), object : TypeReference<DynamicLotDetailsDto>() {})
        vehicleDto.currentBid = dynamicLotDto.currentBid
        return vehicleDto
    }
}