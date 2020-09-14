package by.runets.vehiclescrapper

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//ToDo
// 1. DamageType
@SpringBootApplication
class VehicleScrapperApplication

fun main(args: Array<String>) {
    runApplication<VehicleScrapperApplication>(*args) {
        val path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", "$path/src/main/resources/chromedriver.exe")
    }
}
