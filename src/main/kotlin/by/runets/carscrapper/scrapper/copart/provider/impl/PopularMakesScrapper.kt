package by.runets.carscrapper.scrapper.copart.provider.impl

import by.runets.carscrapper.database.domain.lookup.Lookup
import by.runets.carscrapper.database.domain.lookup.vehicle.MakeLookup
import by.runets.carscrapper.scrapper.copart.provider.IScrapper
import org.openqa.selenium.By
import org.openqa.selenium.remote.RemoteWebDriver
import org.springframework.stereotype.Service
import java.util.*

@Service
class PopularMakesScrapper : IScrapper<MakeLookup> {

    private val page = "https://www.copart.com/vehicleFinder/"

    override fun scrap(webDriver: RemoteWebDriver): Set<MakeLookup> {
        val set = mutableSetOf<MakeLookup>()

        webDriver.get(page)

        webDriver.findElementsByClassName("panel-default")
                .filter { p -> p.findElement(By.className("panel-heading")).text == "Popular Makes" }
                .map {
                    it.findElements(By.className("list-group-item"))
                            .forEach { p -> set.add(MakeLookup(Lookup(UUID.randomUUID(), p.findElement(By.tagName("span")).text), emptySet())) }
                }

        return set
    }
}