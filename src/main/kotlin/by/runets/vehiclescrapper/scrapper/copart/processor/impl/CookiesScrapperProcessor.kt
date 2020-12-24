package by.runets.vehiclescrapper.scrapper.copart.processor.impl

import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CookiesScrapperProcessor(@Autowired private val chromeDriver: ChromeDriver) : AbstractScrapperProcessor<String>() {
    override suspend fun scrap(criteria: Map<String, Any>?) : String {
        val page = "https://www.copart.com/search/"
        val make = criteria?.get("make") as String
        chromeDriver.get(page + make)
        return HttpUtils.inlineCookies(chromeDriver.manage().cookies)
    }
}