package by.runets.carscrapper.scrapper.copart.provider

import org.openqa.selenium.remote.RemoteWebDriver

interface IScrapper <T> {
    fun scrap(webDriver: RemoteWebDriver) : Set<T>
}