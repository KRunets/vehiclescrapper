package by.runets.vehiclescrapper.controller.copart

import by.runets.vehiclescrapper.persistence.domain.lookup.DamageType
import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.BodyStyleType
import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.TransmissionType
import by.runets.vehiclescrapper.scrapper.copart.service.impl.*
import by.runets.vehiclescrapper.utils.annotation.LogExecutionTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/scrap")
class ScrapController(@Autowired private val popularMakesScrapService: PopularMakesScrapService,
                      @Autowired private val fuelTypeScrapService: FuelTypeScrapService,
                      @Autowired private val damageTypeScrapService: DamageTypeScrapService,
                      @Autowired private val transmissionTypeScrapService: TransmissionTypeScrapService,
                      @Autowired private val bodyStyleTypeScrapService: BodyStyleTypeScrapService,
                      @Autowired private val engineTypeScrapService: EngineTypeScrapService,
                      @Autowired private val modelLookupScrapService: ModelLookupScrapService) {

    @GetMapping("/makes-popular")
    @LogExecutionTime
    suspend fun scrapPoplarMakes(): Set<MakeLookup> {
        return popularMakesScrapService.scrapAndSave()
    }

    @GetMapping("/model-lookup")
    @LogExecutionTime
    suspend fun scrapModelLookup() {
        modelLookupScrapService.scrapAndSaveVoid()
    }

    @GetMapping("/type/fuel")
    @LogExecutionTime
    suspend fun scrapFuelType() {
        fuelTypeScrapService.scrapAndSaveVoid()
    }

    @GetMapping("/type/fuel/make/{make}")
    @LogExecutionTime
    suspend fun scrapFuelTypeByMale(@PathVariable("make") make: String) {
        fuelTypeScrapService.scrapAndSaveByMake(make)
    }

    @GetMapping("/type/damage")
    @LogExecutionTime
    suspend fun scrapDamageType(): Set<DamageType> {
        return damageTypeScrapService.scrapAndSave()
    }

    @GetMapping("/type/transmission")
    @LogExecutionTime
    suspend fun scrapTransmissionType(): Set<TransmissionType> {
        return transmissionTypeScrapService.scrapAndSave()
    }

    @GetMapping("/type/bodystyle")
    @LogExecutionTime
    suspend fun scrapBodyStyleType(): Set<BodyStyleType> {
        return bodyStyleTypeScrapService.scrapAndSave()
    }

    @GetMapping("/type/engine")
    @LogExecutionTime
    suspend fun scrapEngineType() {
        engineTypeScrapService.scrapAndSaveVoid()
    }
}