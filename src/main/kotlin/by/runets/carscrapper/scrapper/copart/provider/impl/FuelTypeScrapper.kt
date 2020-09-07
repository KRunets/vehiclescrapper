package by.runets.carscrapper.scrapper.copart.provider.impl

import by.runets.carscrapper.database.domain.lookup.vehicle.FuelType
import by.runets.carscrapper.database.domain.lookup.vehicle.MakeLookup
import by.runets.carscrapper.database.service.lookup.vehicle.MakeLookupService
import by.runets.carscrapper.scrapper.copart.provider.IScrapper
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FuelTypeScrapper(@Autowired private val makeLookupService: MakeLookupService,
                       @Autowired private val chromeDriver: ChromeDriver) : IScrapper<FuelType> {

    val page = "https://www.copart.com/search/"

    override suspend fun scrap(): Set<FuelType> {
        val fuelTypeSet = mutableSetOf<FuelType>()

        val makeLookupDataSet = makeLookupService.findAll()
        makeLookupDataSet.map { i: MakeLookup ->
            {
                chromeDriver.get(page + i.type!!.toLowerCase())
                chromeDriver.findElements(By.name("FUEL")).forEach { i -> println(i.getAttribute("value")) }
            }
        }

        return fuelTypeSet
    }
}