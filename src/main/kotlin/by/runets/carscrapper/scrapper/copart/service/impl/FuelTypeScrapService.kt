package by.runets.carscrapper.scrapper.copart.service.impl

import by.runets.carscrapper.database.domain.lookup.vehicle.MakeLookup
import by.runets.carscrapper.database.service.lookup.vehicle.FuelTypeService
import by.runets.carscrapper.database.service.lookup.vehicle.MakeLookupService
import by.runets.carscrapper.scrapper.copart.provider.impl.FuelTypeScrapper
import by.runets.carscrapper.scrapper.copart.service.IFuelTypeScrapService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FuelTypeScrapService(@Autowired private val makeLookupService: MakeLookupService,
                           @Autowired private val fuelTypeService: FuelTypeService,
                           @Autowired private val fuelTypeScrapper: FuelTypeScrapper) : IFuelTypeScrapService {

    override suspend fun scrapAndSave() {
        val makeLookupDataSet = makeLookupService.findAll()
        makeLookupDataSet.subscribe { makeLookup: MakeLookup ->
            run {
                val fuelTypeDataSet = fuelTypeScrapper.scrap(makeLookup)
                println("Parsed data $fuelTypeDataSet")
                fuelTypeService.saveAllBlocking(fuelTypeDataSet)
            }
        }
    }
}
