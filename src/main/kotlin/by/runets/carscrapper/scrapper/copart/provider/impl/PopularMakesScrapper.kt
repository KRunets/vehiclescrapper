package by.runets.carscrapper.scrapper.copart.provider.impl

import by.runets.carscrapper.database.domain.lookup.vehicle.MakeLookup
import by.runets.carscrapper.scrapper.copart.provider.IScrapper
import org.openqa.selenium.By
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.stereotype.Service
import java.util.*

@Service
class PopularMakesScrapper : IScrapper<MakeLookup> {

    private val page = "https://www.copart.com/vehicleFinder/"

    override fun scrap(webDriver: RemoteWebDriver): Set<MakeLookup> {
        val set = mutableSetOf<MakeLookup>()

        webDriver.get(page)

        val wait = WebDriverWait(webDriver, 1)

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("list-group-item")))

        webDriver.findElementsByClassName("panel-default")
                .filter { p -> p.findElement(By.className("panel-heading")).text == "Popular Makes" }
                .map {
                    it.findElements(By.className("list-group-item"))
                            .forEach { p -> set.add(MakeLookup(p.findElement(By.tagName("span")).text)) }
                }
        return set
    }
}