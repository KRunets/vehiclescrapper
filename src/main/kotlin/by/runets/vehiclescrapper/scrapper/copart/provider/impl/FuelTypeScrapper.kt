package by.runets.vehiclescrapper.scrapper.copart.provider.impl

import by.runets.vehiclescrapper.database.domain.lookup.vehicle.FuelType
import by.runets.vehiclescrapper.database.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.scrapper.copart.provider.IFuelTypeScrapper
import by.runets.vehiclescrapper.utils.HtmlTagUtils
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FuelTypeScrapper(@Autowired private val chromeDriver: ChromeDriver) : AbstractScrapper<FuelType>(), IFuelTypeScrapper {


    override fun scrap(makeLookup: MakeLookup): Set<FuelType> {
        val fuelTypeSet = mutableSetOf<FuelType>()

        val page = "https://www.copart.com/search/"

        chromeDriver.get(page + makeLookup.type!!.toLowerCase())

        val wait = WebDriverWait(chromeDriver, 5)
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(HtmlTagUtils.LIST_GROUP_ITEM)))

        chromeDriver.findElements(By.name(HtmlTagUtils.FUEL)).forEach { pageData -> fuelTypeSet.add(FuelType(pageData.getAttribute(HtmlTagUtils.VALUE_ATTRIBUTE), makeLookup.id!!)) }

        return fuelTypeSet
    }
}