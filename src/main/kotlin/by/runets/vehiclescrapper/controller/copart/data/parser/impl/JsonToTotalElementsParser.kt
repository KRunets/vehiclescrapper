package by.runets.vehiclescrapper.controller.copart.data.parser.impl

import by.runets.vehiclescrapper.controller.copart.data.parser.IParser
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

class JsonToTotalElementsParser(private val objectMapper: ObjectMapper) : IParser<ResponseEntity<String>, String> {
    override fun parse(totalElementsResponseEntity: ResponseEntity<String>): String {
        val jsonNode: JsonNode = objectMapper.readValue(totalElementsResponseEntity.body, JsonNode::class.java)
        return jsonNode.get("data").get("results").get("totalElements").toString()
    }
}