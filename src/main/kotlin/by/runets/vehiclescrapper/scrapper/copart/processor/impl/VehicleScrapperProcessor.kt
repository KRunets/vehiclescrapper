package by.runets.vehiclescrapper.scrapper.copart.processor.impl

import by.runets.vehiclescrapper.persistence.domain.Vehicle
import by.runets.vehiclescrapper.scrapper.copart.utils.ScrapperUtils
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VehicleScrapperProcessor(@Autowired private val chromeDriver: ChromeDriver) : AbstractScrapperProcessor<Vehicle>() {

    override fun scrapAll(searchCriteria: Map<String, Any>?): Set<Vehicle> {
        val vehicleSet = mutableSetOf<Vehicle>()

        val page = "https://www.copart.com/search/"

        val make = searchCriteria?.get(ScrapperUtils.MAKE) as String
        chromeDriver.get(page + make.toLowerCase())

        Thread.sleep(500)

        fillFormByCriteria(searchCriteria)

        return vehicleSet
    }

    private fun fillFormByCriteria(searchCriteria: Map<String, Any>?) {
        searchCriteria?.forEach { (key, value) ->
            run {
               /* val compositeObject = searchPageMap[key]
                if (compositeObject != null) {
                    ScrapperUtils.clickBy(chromeDriver, By.xpath(compositeObject.panelXPath))
                    val elements = chromeDriver.findElements(By.name(compositeObject.scrollPaneListName))
                    if (value is List<*>) {
                        val criteriaList = value as List<String>
                        elements.filter { element -> criteriaList.contains(element.text) }
                                .forEach { element -> element.click() }
                    } else {
                        val criteria = value as String
                        elements.filter { element -> element.text == criteria }
                                .forEach { element -> element.click() }
                    }
                }*/
            }
        }
    }

}