package by.runets.carscrapper

import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.boot.test.context.SpringBootTest
import java.io.File
import java.lang.Thread.sleep

@SpringBootTest
class CarscrapperApplicationTests {

	@Test
	fun contextLoads() {
		val path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "$path/src/main/resources/chromedriver.exe")

		val driver = ChromeDriver()

		driver.get("https://www.copart.com/vehicleFinder/")

		driver.findElementsByClassName("panel-default")
				.filter { p -> p.findElement(By.className("panel-heading")).text == "Popular Makes" }
				.map { it.findElements(By.className("list-group-item")).forEach { p -> println(p.findElement(By.tagName("span")).text) } }

		driver.close()
	}
}
