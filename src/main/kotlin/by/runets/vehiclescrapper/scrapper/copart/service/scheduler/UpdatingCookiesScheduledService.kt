package by.runets.vehiclescrapper.scrapper.copart.service.scheduler

import by.runets.vehiclescrapper.scrapper.copart.utils.HttpUtils
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.http.HttpHeaders
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service


@Service
class UpdatingCookiesScheduledService(@Autowired private val chromeDriver: ChromeDriver,
                                      @Autowired private val headers: HttpHeaders) : ApplicationListener<ApplicationReadyEvent> {

    @Scheduled(cron = "0 0 0/1 ? * *")
    fun scheduleAction() {
        updateCookies()
    }

    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        updateCookies()
    }

    private fun updateCookies() {
        val page = "https://www.copart.com/search/toyota/"
        chromeDriver.get(page)
        val cookies = HttpUtils.inlineCookies(chromeDriver.manage().cookies)
        HttpUtils.updateCookieInHeaders(headers, cookies)
    }

}