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
                chromeDriver.findElementsByClassName("list-group-item")
                        .filter { p -> p.findElement(By.xpath("//*[@data-id='Fuel Type']")).text == "Fuel Type" }
                        .map { it.findElement(By.className("list-unstyled")) }
                        .map {
                            it.findElements(By.className("checkbox"))
                                    .forEach { i -> println(i.findElement(By.tagName("abbr")).text) }
                        }
            }
        }

        return fuelTypeSet
    }
}