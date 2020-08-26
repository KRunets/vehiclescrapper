package by.runets.carscrapper.scrapper.service.copart

import by.runets.carscrapper.database.domain.lookup.vehicle.FuelType
import by.runets.carscrapper.database.service.lookup.vehicle.FuelTypeService
import by.runets.carscrapper.scrapper.provider.copart.FuelTypeScrapper
import by.runets.carscrapper.scrapper.service.IScrapService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FuelTypeScrapService(@Autowired private var fuelTypeScrapper: FuelTypeScrapper,
                           @Autowired private var fuelTypeService: FuelTypeService) : IScrapService<FuelType> {
    private val url = "https://www.copart.com/search/bmw/?displayStr=Bmw&from=%2FvehicleFinder"

    override suspend fun scrapAndSave() {
        val data = fuelTypeScrapper.scrap(url);
        fuelTypeService.saveAll(data)
    }
}