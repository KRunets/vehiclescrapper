package by.runets.vehiclescrapper.scrapper.copart.provider.impl

import by.runets.vehiclescrapper.database.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.scrapper.copart.provider.IScrapper
import by.runets.vehiclescrapper.utils.HtmlTagUtils
import by.runets.vehiclescrapper.utils.StringUtils
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PopularMakesScrapper(@Autowired private val chromeDriver: ChromeDriver) : AbstractScrapper<Set<MakeLookup>>(), IScrapper<Set<MakeLookup>> {


    override suspend fun scrap(): Set<MakeLookup> {
        val set = mutableSetOf<MakeLookup>()

        val page = "https://www.copart.com/vehicleFinder/"
        chromeDriver.get(page)

        val wait = WebDriverWait(chromeDriver, 1)
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(HtmlTagUtils.LIST_GROUP_ITEM)))

        chromeDriver.findElementsByClassName(HtmlTagUtils.PANEL_DEFAULT)
                .filter { p -> p.findElement(By.className(HtmlTagUtils.PANEL_HEADING)).text == HtmlTagUtils.POPULAR_MAKES }
                .map {
                    it.findElements(By.className(HtmlTagUtils.LIST_GROUP_ITEM))
                            .forEach { p ->
                                run {
                                    val model = p.findElement(By.tagName("span")).text.toLowerCase()
                                    set.add(MakeLookup(StringUtils.replaceDash(model)))
                                }
                            }
                }

        return set
    }

}