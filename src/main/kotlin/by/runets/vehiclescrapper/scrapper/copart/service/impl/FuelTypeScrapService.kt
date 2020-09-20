package by.runets.vehiclescrapper.scrapper.copart.service.impl

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.FuelType
import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.FuelTypeService
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.MakeLookupService
import by.runets.vehiclescrapper.scrapper.copart.provider.impl.FuelTypeScrapper
import by.runets.vehiclescrapper.utils.annotation.LogExecutionTime
import by.runets.vehiclescrapper.utils.coroutines.onNext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FuelTypeScrapService(@Autowired private val makeLookupService: MakeLookupService,
                           @Autowired private val fuelTypeService: FuelTypeService,
                           @Autowired private val fuelTypeScrapper: FuelTypeScrapper) : AbstractScrapService<FuelType>() {
    @LogExecutionTime
    override suspend fun scrapAndSaveVoid() {
        val fuelTypeDataSet = mutableSetOf<FuelType>()

        val makeLookupDataSet = makeLookupService.findMakeLookupSetByFuelType()
        makeLookupDataSet.map { makeLookup: MakeLookup ->
            run {
                val data = fuelTypeScrapper.scrapByCriteria(makeLookup)
                fuelTypeDataSet.addAll(data)
            }
        }.onNext { fuelTypeService.saveAll(fuelTypeDataSet) }.subscribe()
    }
    @LogExecutionTime
    override suspend fun scrapAndSaveByMake(make: String) {
        val makeLookup = makeLookupService.findByType(make)
        val data = fuelTypeScrapper.scrapByCriteria(makeLookup)
        fuelTypeService.saveAll(data)
    }
}

