package by.runets.carscrapper.scrapper.copart.provider.impl

import by.runets.carscrapper.database.domain.lookup.vehicle.FuelType
import by.runets.carscrapper.database.domain.lookup.vehicle.MakeLookup
import by.runets.carscrapper.scrapper.copart.provider.IFuelTypeScrapper
import by.runets.carscrapper.utils.HtmlTagUtils
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FuelTypeScrapper(@Autowired private val chromeDriver: ChromeDriver) : AbstractScrapper<FuelType>(),  IFuelTypeScrapper {

    val page = "https://www.copart.com/search/"

    override fun scrap(makeLookup: MakeLookup): Set<FuelType> {
        val fuelTypeSet = mutableSetOf<FuelType>()

        chromeDriver.get(page + makeLookup.type!!.toLowerCase())

        val wait = WebDriverWait(chromeDriver, 5)
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(HtmlTagUtils.LIST_GROUP_ITEM)))

        chromeDriver.findElements(By.name(HtmlTagUtils.FUEL)).forEach { pageData -> fuelTypeSet.add(FuelType(pageData.getAttribute(HtmlTagUtils.VALUE_ATTRIBUTE), makeLookup)) }

        return fuelTypeSet
    }
}