package by.runets.vehiclescrapper.scrapper.copart.provider.impl

import by.runets.vehiclescrapper.database.domain.lookup.DamageType
import by.runets.vehiclescrapper.scrapper.copart.provider.IScrapper
import by.runets.vehiclescrapper.utils.HtmlTagUtils
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class DamageTypeScrapper(@Autowired private val chromeDriver: ChromeDriver) : AbstractScrapper<Set<DamageType>>(), IScrapper<Set<DamageType>> {
    override suspend fun scrap(): Set<DamageType>? {
        val damageTypeSet = mutableSetOf<DamageType>()

        val page = "https://www.copart.com/search/toyota/"
        chromeDriver.get(page)

        val wait = WebDriverWait(chromeDriver, 5)
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(HtmlTagUtils.LIST_GROUP_ITEM)))

        click()
        scroll(chromeDriver.findElement(By.id("collapseinside13")))
        chromeDriver
                .findElements(By.name(HtmlTagUtils.DAMAGE))
                .forEach { pageData ->
                    run {
                        damageTypeSet.add(DamageType(pageData.getAttribute(HtmlTagUtils.VALUE_ATTRIBUTE)))
                    }
                }

        return damageTypeSet
    }

    private fun click() {
        chromeDriver.findElement(By.xpath("//a[@href='#collapseinside13']")).click()
    }

    private fun scroll(webelement: WebElement) {
        val dragger = Actions(chromeDriver)
        val numberOfPixelsToDragTheScrollbarDown = 10
        var i = 10
        while (i < 50) {
            dragger.moveToElement(webelement).clickAndHold().moveByOffset(0, 10).release(webelement).build().perform()
            i += numberOfPixelsToDragTheScrollbarDown
        }
        Thread.sleep(500)
    }
}