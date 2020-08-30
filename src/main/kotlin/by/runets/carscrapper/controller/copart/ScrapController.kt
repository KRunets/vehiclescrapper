package by.runets.carscrapper.controller.copart

import by.runets.carscrapper.database.domain.lookup.vehicle.MakeLookup
import by.runets.carscrapper.scrapper.copart.provider.IScrapper
import by.runets.carscrapper.scrapper.copart.service.impl.PopularMakesScrapService
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ScrapController(@Autowired private val popularMakesScrapService: PopularMakesScrapService) {

    @GetMapping("/scrap/makes-popular")
    suspend fun scrapPoplarMakes(): Set<MakeLookup> {
        return popularMakesScrapService.scrapAndSave()
    }

}