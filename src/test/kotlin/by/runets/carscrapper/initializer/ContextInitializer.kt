package by.runets.carscrapper.initializer

import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.PostgreSQLContainer

class ContextInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
    val container = PostgreSQLContainer<Nothing>("postgres:11.1")
            .apply {
                withDatabaseName("carscrapper")
                withUsername("postgres")
                withPassword("postgres")
            }

    override fun initialize(p0: ConfigurableApplicationContext) {
        TestPropertyValues.of(
                "spring.datasource.url=" + container.getJdbcUrl(),
                "spring.datasource.username=" + container.getUsername(),
                "spring.datasource.password=" + container.getPassword()
        )
    }
}