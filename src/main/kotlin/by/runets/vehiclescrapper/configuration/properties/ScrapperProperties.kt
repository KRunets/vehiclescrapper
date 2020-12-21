package by.runets.vehiclescrapper.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component


@Component
@ConfigurationProperties(prefix = "scrapper")
data class ScrapperProperties(var modelTimeout: Long = 300, var retryLimit: Long = 10)