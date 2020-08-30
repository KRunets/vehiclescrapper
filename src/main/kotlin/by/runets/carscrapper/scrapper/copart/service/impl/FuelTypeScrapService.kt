package by.runets.carscrapper.scrapper.copart.service.impl

import by.runets.carscrapper.database.domain.lookup.vehicle.FuelType
import by.runets.carscrapper.database.service.lookup.vehicle.FuelTypeService
import by.runets.carscrapper.scrapper.copart.service.IScrapService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FuelTypeScrapService(@Autowired private var fuelTypeService: FuelTypeService) : IScrapService<FuelType> {
    override suspend fun scrapAndSave(): FuelType {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}