package by.runets.vehiclescrapper.scrapper.copart.provider.impl

import by.runets.vehiclescrapper.persistence.domain.Vehicle
import by.runets.vehiclescrapper.scrapper.copart.utils.HtmlTagUtils
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils.Companion.clickBy
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils.Companion.waitBy
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VehicleScrapper(@Autowired private val chromeDriver: ChromeDriver) : AbstractScrapper<Vehicle>() {

    override fun scrapByCriteria(searchCriteria: Map<String, Any>?): Set<Vehicle> {
        val vehicleSet = mutableSetOf<Vehicle>()

        val page = "https://www.copart.com/search/"
/*

        val make = searchCriteria.criteriaMap?.get(ScrapperUtils.MAKE)
        chromeDriver.get(page + make!!.toLowerCase())
*/

        waitBy(chromeDriver, By.className(HtmlTagUtils.LIST_GROUP_ITEM))

        clickBy(chromeDriver, By.xpath(HtmlTagUtils.ENGINE_COLLAPSIBLE_BTN))


    /*    chromeDriver.findElements(By.name(HtmlTagUtils.FUEL))
                .forEach { pageData -> vehicleSet.add(FuelType(pageData.getAttribute(HtmlTagUtils.VALUE_ATTRIBUTE), makeLookup.id!!)) }
*/
        return vehicleSet
    }/*

    private fun fillFormByCriteria(criteria: SearchCriteria) {
        criteria.criteriaMap?.forEach { (_, value) ->
            run {
                clickBy(chromeDriver, By.xpath(value))
            }
        }
    }*/

}