package by.runets.vehiclescrapper.scrapper.copart.service.impl.lookup

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.FuelType
import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.FuelTypeService
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.MakeLookupService
import by.runets.vehiclescrapper.scrapper.copart.processor.impl.lookup.FuelTypeScrapperProcessor
import by.runets.vehiclescrapper.scrapper.copart.service.impl.AbstractScrapService
import by.runets.vehiclescrapper.utils.annotation.LogExecutionTime
import by.runets.vehiclescrapper.utils.coroutines.onNext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FuelTypeScrapService(@Autowired private val makeLookupService: MakeLookupService,
                           @Autowired private val fuelTypeService: FuelTypeService,
                           @Autowired private val fuelTypeScrapper: FuelTypeScrapperProcessor) : AbstractScrapService<FuelType>() {
    @LogExecutionTime
    override suspend fun scrapAndSaveVoid() {
        val fuelTypeDataSet = mutableSetOf<FuelType>()
        val searchCriteria = mutableMapOf<String, Any>()
        val makeLookupDataSet = makeLookupService.findMakeLookupSetByFuelType()

        makeLookupDataSet.map { makeLookup: MakeLookup ->
            run {
                searchCriteria[MakeLookup::javaClass.name] = makeLookup
                val data = fuelTypeScrapper.scrapAll(searchCriteria)
                fuelTypeDataSet.addAll(data)
            }
        }.onNext { fuelTypeService.saveAll(fuelTypeDataSet) }.subscribe()
    }
    @LogExecutionTime
    override suspend fun scrapAndSaveByMake(make: String) {
        val makeLookup = makeLookupService.findByType(make)
        val searchCriteria = mutableMapOf<String, Any>()
        searchCriteria[MakeLookup::javaClass.name] = makeLookup
        val data = fuelTypeScrapper.scrapAll(searchCriteria)
        fuelTypeService.saveAll(data)
    }
}

