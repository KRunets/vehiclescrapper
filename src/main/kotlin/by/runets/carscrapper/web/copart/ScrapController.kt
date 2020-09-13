package by.runets.carscrapper.web.copart

import by.runets.carscrapper.database.domain.lookup.vehicle.MakeLookup
import by.runets.carscrapper.scrapper.copart.service.impl.FuelTypeScrapService
import by.runets.carscrapper.scrapper.copart.service.impl.PopularMakesScrapService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/scrap")
class ScrapController(@Autowired private val popularMakesScrapService: PopularMakesScrapService,
                      @Autowired private val fuelTypeScrapService: FuelTypeScrapService) {

    @GetMapping("/makes-popular")
    suspend fun scrapPoplarMakes(): Set<MakeLookup> {
        return popularMakesScrapService.scrapAndSave()
    }

    @GetMapping("/type/fuel")
    suspend fun scrapFuelType() {
        fuelTypeScrapService.scrapAndSave()
    }

    @GetMapping("/type/fuel/make/{make}")
    suspend fun scrapFuelTypeByMale(@PathVariable("make") make: String) {
        fuelTypeScrapService.scrapAndSaveByMake(make)
    }

}