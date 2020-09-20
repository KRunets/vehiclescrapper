package by.runets.vehiclescrapper.scrapper.copart.provider.impl

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.EngineType
import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.scrapper.copart.provider.IEngineTypeScrapper
import by.runets.vehiclescrapper.scrapper.copart.utils.HtmlTagUtils
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils.Companion.clickBy
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils.Companion.scrollElement
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils.Companion.waitBy
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EngineTypeScrapper(@Autowired private val chromeDriver: ChromeDriver) : AbstractScrapper<EngineType>(), IEngineTypeScrapper {
    override fun scrap(makeLookup: MakeLookup): Set<EngineType> {
        val engineTypeSet = mutableSetOf<EngineType>()

        val page = "https://www.copart.com/search/"

        chromeDriver.get(page + makeLookup.type!!.toLowerCase())
        waitBy(chromeDriver, By.className(HtmlTagUtils.LIST_GROUP_ITEM))
        clickBy(chromeDriver, By.xpath(HtmlTagUtils.ENGINE_COLLAPSIBLE_BTN))
        scrollElement(chromeDriver, chromeDriver.findElement(By.id(HtmlTagUtils.ENGINE_COLLAPSIBLE_PANEL)))

        chromeDriver
                .findElements(By.name(HtmlTagUtils.ENGN))
                .forEach { pageData ->
                    run {
                        val engineType = replaceEmptySpace(pageData.getAttribute(HtmlTagUtils.VALUE_ATTRIBUTE))
                        engineTypeSet.add(EngineType(engineType, makeLookup.id!!))
                    }
                }

        return engineTypeSet
    }

    private fun replaceEmptySpace(source: String): String {
        return source.split("  ")[0]
    }

}