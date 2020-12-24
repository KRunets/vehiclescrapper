package by.runets.vehiclescrapper.scrapper.copart.processor.impl.lookup

import by.runets.vehiclescrapper.configuration.properties.ScrapperProperties
import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.ModelLookup
import by.runets.vehiclescrapper.scrapper.copart.processor.impl.AbstractScrapperProcessor
import by.runets.vehiclescrapper.scrapper.copart.utils.HtmlTagUtils
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ModelLookupScrapperProcessor(@Autowired private val chromeDriver: ChromeDriver, @Autowired private val scrapperProperties : ScrapperProperties) : AbstractScrapperProcessor<ModelLookup>() {


    override fun scrapAll(searchCriteria: Map<String, Any>?): Set<ModelLookup> {
        val modelLookupSet = mutableSetOf<ModelLookup>()

        val page = "https://www.copart.com/search/"

        val makeLookup = searchCriteria?.get(MakeLookup::javaClass.name) as MakeLookup

        chromeDriver.get(page + makeLookup.type!!.toLowerCase())
        ScrapperUtils.waitBy(chromeDriver, By.className(HtmlTagUtils.LIST_GROUP_ITEM))
        ScrapperUtils.clickBy(chromeDriver, By.xpath(HtmlTagUtils.MODEL_COLLAPSIBLE_BTN))
        ScrapperUtils.scrollElement(chromeDriver, chromeDriver.findElements(By.name(HtmlTagUtils.MODL)).first())

        Thread.sleep(scrapperProperties.modelTimeout)

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
}