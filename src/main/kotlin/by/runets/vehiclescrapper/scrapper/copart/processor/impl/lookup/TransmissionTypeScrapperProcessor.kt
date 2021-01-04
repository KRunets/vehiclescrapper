package by.runets.vehiclescrapper.scrapper.copart.processor.impl.lookup

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.TransmissionType
import by.runets.vehiclescrapper.scrapper.copart.processor.impl.AbstractScrapperProcessor
import by.runets.vehiclescrapper.scrapper.copart.utils.HtmlTagUtils
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils.Companion.waitBy
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransmissionTypeScrapperProcessor(@Autowired private val chromeDriver: ChromeDriver) : AbstractScrapperProcessor<Set<TransmissionType>>() {

    override suspend fun scrap(): Set<TransmissionType> {
        val set = mutableSetOf<TransmissionType>()

        val page = "https://www.copart.com/search/toyota/"
        chromeDriver.get(page)

        waitBy(chromeDriver, By.className(HtmlTagUtils.LIST_GROUP_ITEM))
        chromeDriver
                .findElements(By.name(HtmlTagUtils.TRANSMISSION_TYPE))
                .forEach { pageData ->
                    run {
                        set.add(TransmissionType(pageData.getAttribute(HtmlTagUtils.VALUE_ATTRIBUTE)))
                    }
                }

        return set
    }

}