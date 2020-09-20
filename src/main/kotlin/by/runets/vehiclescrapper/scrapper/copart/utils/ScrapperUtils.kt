package by.runets.vehiclescrapper.scrapper.copart.utils

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class ScrapperUtils {


    companion object {
        val MAKE = "make"
        val MODEL = "model"
        val YEAR = "year"
        val BODY_STYLE = "bodyStyleType"
        val ENGINE_TYPE = "engineType"
        val FUEL_TYPE = "fuelType"
        val ODOMETER = "odometer"
        val TRANSMISSION_TYPE = "transmissionType"

        fun clickBy(chromeDriver: ChromeDriver, by: By) {
            chromeDriver.findElement(by).click()
        }

        fun waitBy(chromeDriver: ChromeDriver, by: By) {
            val wait = WebDriverWait(chromeDriver, 5)
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by))
        }

        fun scrollElement(chromeDriver: ChromeDriver, webelement: WebElement) {
            val actions = Actions(chromeDriver)
            for (i in 0..5) {
                actions.moveToElement(webelement)
                        .clickAndHold()
                        .moveByOffset(0, 10)
                        .release(webelement)
                        .build()
                        .perform()
            }
            Thread.sleep(1000)
        }
    }
}