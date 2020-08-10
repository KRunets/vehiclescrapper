package by.runets.carscrapper.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component


@Component
@ConfigurationProperties(prefix = "sql")
data class DatabaseProperties(
        var host: String = "localhost",
        var username: String = "postgres",
        var pass: String = "root",
        var port: Int = 5432,
        var initializeSize: Int = 10,
        var maxIdleTime: Long = 1,
        var maxSize: Int = 10,
        var validationQuery: String = "SELECT 1"
)
