package by.runets.vehiclescrapper.scrapper.copart.executor.impl.lookup

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.scrapper.copart.executor.impl.AbstractScrapperExecutor
import by.runets.vehiclescrapper.scrapper.copart.utils.HtmlTagUtils
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils.Companion.waitBy
import by.runets.vehiclescrapper.utils.StringUtils
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PopularMakesScrapperExecutor(@Autowired private val chromeDriver: ChromeDriver) : AbstractScrapperExecutor<Set<MakeLookup>>() {

    override suspend fun scrap(): Set<MakeLookup> {
        val set = mutableSetOf<MakeLookup>()

        val page = "https://www.copart.com/vehicleFinder/"

        chromeDriver.get(page)
        waitBy(chromeDriver, By.className(HtmlTagUtils.LIST_GROUP_ITEM))

        chromeDriver.findElementsByClassName(HtmlTagUtils.PANEL_DEFAULT)
                .filter { p -> p.findElement(By.className(HtmlTagUtils.PANEL_HEADING)).text == HtmlTagUtils.POPULAR_MAKES }
                .map {
                    it.findElements(By.className(HtmlTagUtils.LIST_GROUP_ITEM))
                            .forEach { p ->
                                run {
                                    val model = p.findElement(By.tagName("span")).text.toLowerCase()
                                    set.add(MakeLookup(StringUtils.concat(model)))
                                }
                            }
                }

        return set
    }

}