package by.runets.vehiclescrapper.scrapper.copart.processor.impl.lookup

import by.runets.vehiclescrapper.configuration.properties.ScrapperProperties
import by.runets.vehiclescrapper.persistence.domain.lookup.DamageType
import by.runets.vehiclescrapper.scrapper.copart.processor.impl.AbstractScrapperProcessor
import by.runets.vehiclescrapper.scrapper.copart.utils.HtmlTagUtils
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils.Companion.clickBy
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils.Companion.scrollElement
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils.Companion.waitBy
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class DamageTypeScrapperProcessor(@Autowired private val chromeDriver: ChromeDriver, @Autowired private val scrapperProperties : ScrapperProperties) : AbstractScrapperProcessor<Set<DamageType>>() {
    override suspend fun scrap(): Set<DamageType>? {
        val damageTypeSet = mutableSetOf<DamageType>()

        val page = "https://www.copart.com/search/toyota/"
        chromeDriver.get(page)

        waitBy(chromeDriver, By.className(HtmlTagUtils.LIST_GROUP_ITEM))
        clickBy(chromeDriver, By.xpath(HtmlTagUtils.DAMAGE_COLLAPSIBLE_BTN))
        scrollElement(chromeDriver, chromeDriver.findElements(By.name(HtmlTagUtils.DAMAGE)).first())

        Thread.sleep(scrapperProperties.modelTimeout)

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