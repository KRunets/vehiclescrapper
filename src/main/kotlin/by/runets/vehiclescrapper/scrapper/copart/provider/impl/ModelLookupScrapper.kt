package by.runets.vehiclescrapper.scrapper.copart.provider.impl

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.ModelLookup
import by.runets.vehiclescrapper.scrapper.copart.utils.HtmlTagUtils
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ModelLookupScrapper(@Autowired private val chromeDriver: ChromeDriver) : AbstractScrapper<ModelLookup>() {
    override fun scrapByMakeLookup(makeLookup: MakeLookup): Set<ModelLookup> {
        val modelLookupSet = mutableSetOf<ModelLookup>()

        val page = "https://www.copart.com/search/"

        chromeDriver.get(page + makeLookup.type!!.toLowerCase())
        ScrapperUtils.waitBy(chromeDriver, By.className(HtmlTagUtils.LIST_GROUP_ITEM))
        ScrapperUtils.clickBy(chromeDriver, By.xpath(HtmlTagUtils.MODEL_COLLAPSIBLE_BTN))
        ScrapperUtils.scrollElement(chromeDriver, chromeDriver.findElement(By.id(HtmlTagUtils.MODEL_COLLAPSIBLE_PANEL)))

        chromeDriver
                .findElements(By.name(HtmlTagUtils.MODL))
                .forEach { pageData ->
                    run {
                        val model = pageData.getAttribute(HtmlTagUtils.VALUE_ATTRIBUTE)
                        modelLookupSet.add(ModelLookup(makeLookup.id!!, model))
                    }
                }

        return modelLookupSet
    }

    private fun replaceEmptySpace(source: String): String {
        return source.split(" ")[0]
    }
}