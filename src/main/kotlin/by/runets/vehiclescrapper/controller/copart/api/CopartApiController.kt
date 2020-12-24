package by.runets.vehiclescrapper.controller.copart.api

import by.runets.vehiclescrapper.scrapper.copart.processor.impl.CookiesScrapperProcessor
import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/copart/api")
class CopartApiController(@Autowired private val restTemplate: RestTemplate,
                          @Autowired private val headers: HttpHeaders,
                          @Autowired private val cookiesScrapperProcessor: CookiesScrapperProcessor) {

    val LOTS_SEARCH = "https://www.copart.com/public/lots/search"

    @PostMapping("/lots/search")
    suspend fun search(@RequestBody searchCriteria : Map<String, Any>) {
        val requestEntity = HttpEntity(HttpUtils.BODY.replace("size=0", "size=" + searchCriteria["size"]), headers)
        val responseEntity: ResponseEntity<String> = restTemplate.exchange(LOTS_SEARCH, HttpMethod.POST, requestEntity, String::class.java)

        println(responseEntity)
    }
}