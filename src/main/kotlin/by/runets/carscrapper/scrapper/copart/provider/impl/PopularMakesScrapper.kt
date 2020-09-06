package by.runets.carscrapper.scrapper.copart.provider.impl

import by.runets.carscrapper.database.domain.lookup.vehicle.MakeLookup
import by.runets.carscrapper.scrapper.copart.provider.IScrapper
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PopularMakesScrapper(@Autowired private val chromeDriver: ChromeDriver) : IScrapper<MakeLookup> {

    private val page = "https://www.copart.com/vehicleFinder/"

    override suspend fun scrap(): Set<MakeLookup> {
        val set = mutableSetOf<MakeLookup>()

        chromeDriver.get(page)

        val wait = WebDriverWait(chromeDriver, 1)

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("list-group-item")))

        chromeDriver.findElementsByClassName("panel-default")
                .filter { p -> p.findElement(By.className("panel-heading")).text == "Popular Makes" }
                .map {
                    it.findElements(By.className("list-group-item"))
                            .forEach { p -> set.add(MakeLookup(p.findElement(By.tagName("span")).text)) }
                }
        return set
    }
}