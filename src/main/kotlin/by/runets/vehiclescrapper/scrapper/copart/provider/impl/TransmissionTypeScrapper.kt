package by.runets.vehiclescrapper.scrapper.copart.provider.impl

import by.runets.vehiclescrapper.database.domain.lookup.vehicle.TransmissionType
import by.runets.vehiclescrapper.scrapper.copart.provider.IScrapper
import by.runets.vehiclescrapper.utils.HtmlTagUtils
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransmissionTypeScrapper(@Autowired private val chromeDriver: ChromeDriver) : AbstractScrapper<Set<TransmissionType>>(), IScrapper<Set<TransmissionType>> {

    override suspend fun scrap(): Set<TransmissionType> {
        val set = mutableSetOf<TransmissionType>()

        val page = "https://www.copart.com/search/toyota/"
        chromeDriver.get(page)

        val wait = WebDriverWait(chromeDriver, 5)
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(HtmlTagUtils.LIST_GROUP_ITEM)))

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