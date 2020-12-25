package by.runets.vehiclescrapper.controller.copart.api

import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils
import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils.Companion.FIRST_VEHICLE
import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils.Companion.LOTS_SEARCH
import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils.Companion.MAKE_KEY
import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils.Companion.SIZE_KEY
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/copart/api")
class CopartApiController(@Autowired private val restTemplate: RestTemplate,
                          @Autowired private val headers: HttpHeaders,
                          @Autowired private val objectMapper : ObjectMapper ) {

    @PostMapping("/lots/search/all")
    suspend fun searchAll(@RequestBody searchCriteria : Map<String, Any>) {
        var payloadBody = HttpUtils.BODY
                .replace(SIZE_KEY, FIRST_VEHICLE)
                .replace(MAKE_KEY, (searchCriteria["make"] as String).toUpperCase())

        val totalElementsResponseEntity: ResponseEntity<String> = restTemplate.exchange(LOTS_SEARCH, HttpMethod.POST,
                HttpEntity(payloadBody,  headers), String::class.java)

        val jsonNode: JsonNode = objectMapper.readValue(totalElementsResponseEntity.body, JsonNode::class.java)
        val totalElements = jsonNode.get("data").get("results").get("totalElements")

        payloadBody = payloadBody.replace(SIZE_KEY, totalElements.toString())

        val vehiclesResponseEntity: ResponseEntity<String> = restTemplate.exchange(LOTS_SEARCH, HttpMethod.POST,
                HttpEntity(payloadBody,  headers), String::class.java)

        val rootJsonNode: JsonNode = objectMapper.readValue(vehiclesResponseEntity.body, JsonNode::class.java)
        val vehiclesJsonNode = rootJsonNode.get("data").get("results").get("content")

        val list = ArrayList<String>()
        for (vjn in vehiclesJsonNode) {
            list.add(vjn.toString())
        }
        println(list)

    }

    @PostMapping("/lots/search")
    suspend fun search(@RequestBody searchCriteria : Map<String, Any>) {
        val requestEntity = HttpEntity(
                HttpUtils.BODY
                        .replace(MAKE_KEY, (searchCriteria["make"] as String).toUpperCase())
                        .replace(SIZE_KEY, searchCriteria["size"] as String),
                headers)
        val responseEntity: ResponseEntity<String> = restTemplate.exchange(LOTS_SEARCH, HttpMethod.POST, requestEntity, String::class.java)

    }
}