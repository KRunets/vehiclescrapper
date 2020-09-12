package by.runets.carscrapper.scrapper.copart.provider.impl

import by.runets.carscrapper.database.domain.lookup.vehicle.MakeLookup
import by.runets.carscrapper.scrapper.copart.provider.IScrapper
import by.runets.carscrapper.utils.HtmlTagUtils
import by.runets.carscrapper.utils.StringUtils
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PopularMakesScrapper(@Autowired private val chromeDriver: ChromeDriver) : AbstractScrapper<Set<MakeLookup>>(), IScrapper<Set<MakeLookup>> {

    private val page = "https://www.copart.com/vehicleFinder/"

    override suspend fun scrap(): Set<MakeLookup> {
        val set = mutableSetOf<MakeLookup>()

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