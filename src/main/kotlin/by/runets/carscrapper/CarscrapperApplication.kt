package by.runets.carscrapper

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CarscrapperApplication

fun main(args: Array<String>) {
    runApplication<CarscrapperApplication>(*args) {
        val path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", "$path/src/main/resources/chromedriver.exe")
    }
}
