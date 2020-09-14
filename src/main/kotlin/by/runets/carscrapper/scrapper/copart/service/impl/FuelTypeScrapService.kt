package by.runets.carscrapper.scrapper.copart.service.impl

import by.runets.carscrapper.database.domain.lookup.vehicle.FuelType
import by.runets.carscrapper.database.domain.lookup.vehicle.MakeLookup
import by.runets.carscrapper.database.service.lookup.vehicle.FuelTypeService
import by.runets.carscrapper.database.service.lookup.vehicle.MakeLookupService
import by.runets.carscrapper.scrapper.copart.provider.impl.FuelTypeScrapper
import by.runets.carscrapper.scrapper.copart.service.IFuelTypeScrapService
import by.runets.carscrapper.utils.coroutines.onNext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FuelTypeScrapService(@Autowired private val makeLookupService: MakeLookupService,
                           @Autowired private val fuelTypeService: FuelTypeService,
                           @Autowired private val fuelTypeScrapper: FuelTypeScrapper) : IFuelTypeScrapService {

    override suspend fun scrapAndSave() {
        val fuelTypeDataSet = mutableSetOf<FuelType>()

        val makeLookupDataSet = makeLookupService.findAll()
        makeLookupDataSet.map { makeLookup: MakeLookup ->
            run {
                val data = fuelTypeScrapper.scrap(makeLookup)
                println("Parsed data $data")
                fuelTypeDataSet.addAll(data)
            }
        }.onNext { fuelTypeService.saveAll(fuelTypeDataSet) }.subscribe()
    }

    override suspend fun scrapAndSaveByMake(make: String) {
        val makeLookup = makeLookupService.findByType(make)
        val data = fuelTypeScrapper.scrap(makeLookup)
        println("Parsed data $data")
        fuelTypeService.saveAll(data)
    }
}

