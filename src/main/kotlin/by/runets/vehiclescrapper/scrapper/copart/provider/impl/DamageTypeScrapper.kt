package by.runets.vehiclescrapper.scrapper.copart.provider.impl

import by.runets.vehiclescrapper.persistence.domain.lookup.DamageType
import by.runets.vehiclescrapper.scrapper.copart.utils.HtmlTagUtils
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils.Companion.clickBy
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils.Companion.scrollElement
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils.Companion.waitBy
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class DamageTypeScrapper(@Autowired private val chromeDriver: ChromeDriver) : AbstractScrapper<Set<DamageType>>() {
    override suspend fun scrap(): Set<DamageType>? {
        val damageTypeSet = mutableSetOf<DamageType>()

        val page = "https://www.copart.com/search/toyota/"
        chromeDriver.get(page)

        waitBy(chromeDriver, By.className(HtmlTagUtils.LIST_GROUP_ITEM))
        clickBy(chromeDriver, By.xpath(HtmlTagUtils.DAMAGE_COLLAPSIBLE_BTN))
        scrollElement(chromeDriver, chromeDriver.findElement(By.id(HtmlTagUtils.DAMAGE_COLLAPSIBLE_PANEL)))

        chromeDriver
                .findElements(By.name(HtmlTagUtils.DAMAGE))
                .forEach { pageData ->
                    run {
                        damageTypeSet.add(DamageType(pageData.getAttribute(HtmlTagUtils.VALUE_ATTRIBUTE)))
                    }
                }

        return damageTypeSet
    }
}