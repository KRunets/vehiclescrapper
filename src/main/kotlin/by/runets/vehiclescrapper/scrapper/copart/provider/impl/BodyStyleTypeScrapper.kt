package by.runets.vehiclescrapper.scrapper.copart.provider.impl

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.BodyStyleType
import by.runets.vehiclescrapper.scrapper.copart.provider.IScrapper
import by.runets.vehiclescrapper.scrapper.copart.utils.HtmlTagUtils
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils.Companion.clickBy
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils.Companion.scrollElement
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils.Companion.waitBy
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BodyStyleTypeScrapper(@Autowired private val chromeDriver: ChromeDriver) : AbstractScrapper<Set<BodyStyleType>>(), IScrapper<Set<BodyStyleType>> {

    override suspend fun scrap(): Set<BodyStyleType>? {
        val damageTypeSet = mutableSetOf<BodyStyleType>()

        val page = "https://www.copart.com/search/toyota/"
        chromeDriver.get(page)

        waitBy(chromeDriver, By.className(HtmlTagUtils.LIST_GROUP_ITEM))
        clickBy(chromeDriver, By.xpath(HtmlTagUtils.BODY_STYLE_COLLAPSIBLE_BTN))
        scrollElement(chromeDriver, chromeDriver.findElement(By.id(HtmlTagUtils.BODY_STYLE_COLLAPSIBLE_PANEL)))

        chromeDriver
                .findElements(By.name(HtmlTagUtils.BODY))
                .forEach { pageData ->
                    run {
                        damageTypeSet.add(BodyStyleType(pageData.getAttribute(HtmlTagUtils.VALUE_ATTRIBUTE)))
                    }
                }

        return damageTypeSet
    }
}