package by.runets.vehiclescrapper.web.copart

import by.runets.vehiclescrapper.database.domain.lookup.DamageType
import by.runets.vehiclescrapper.database.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.database.domain.lookup.vehicle.TransmissionType
import by.runets.vehiclescrapper.scrapper.copart.service.impl.DamageTypeScrapService
import by.runets.vehiclescrapper.scrapper.copart.service.impl.FuelTypeScrapService
import by.runets.vehiclescrapper.scrapper.copart.service.impl.PopularMakesScrapService
import by.runets.vehiclescrapper.scrapper.copart.service.impl.TransmissionTypeScrapService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/scrap")
class ScrapController(@Autowired private val popularMakesScrapService: PopularMakesScrapService,
                      @Autowired private val fuelTypeScrapService: FuelTypeScrapService,
                      @Autowired private val damageTypeScrapService: DamageTypeScrapService,
                      @Autowired private val transmissionTypeScrapService: TransmissionTypeScrapService) {

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

    @GetMapping("/type/damage")
    suspend fun scrapDamageType() : Set<DamageType> {
        return damageTypeScrapService.scrapAndSave()
    }

    @GetMapping("/type/transmission")
    suspend fun scrapTransmissionType() : Set<TransmissionType> {
        return transmissionTypeScrapService.scrapAndSave()
    }


}