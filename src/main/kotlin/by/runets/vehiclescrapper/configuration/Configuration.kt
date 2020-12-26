package by.runets.vehiclescrapper.configuration

import by.runets.vehiclescrapper.configuration.properties.DatabaseProperties
import by.runets.vehiclescrapper.utils.UUIDConverter
import com.fasterxml.jackson.databind.ObjectMapper
import io.r2dbc.pool.ConnectionPool
import io.r2dbc.pool.ConnectionPoolConfiguration
import io.r2dbc.pool.PoolingConnectionFactoryProvider
import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions.*
import org.apache.commons.lang3.StringUtils
import org.modelmapper.ModelMapper
import org.openqa.selenium.PageLoadStrategy
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.core.convert.converter.Converter
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.r2dbc.core.R2dbcEntityOperations
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.http.HttpHeaders
import org.springframework.transaction.reactive.TransactionalOperator
import org.springframework.web.client.RestTemplate
import java.time.Duration
import java.util.*


@Configuration
@EnableAspectJAutoProxy
@EnableR2dbcRepositories("by.runets.vehiclescrapper")
class Configuration(private val databaseProperties: DatabaseProperties) : AbstractR2dbcConfiguration() {
    private val POSTGRES_DRIVER: String = "pool";
    private val POSTGRES_PROTOCOL: String = "postgresql";

    private val connectionFactory: ConnectionFactory = ConnectionFactories.get(builder()
            .option(DRIVER, POSTGRES_DRIVER)
            .option(PROTOCOL, POSTGRES_PROTOCOL) // driver identifier, PROTOCOL is delegated as DRIVER by the pool.
            .option(DATABASE, databaseProperties.databaseName)
            .option(HOST, databaseProperties.host)
            .option(PORT, databaseProperties.port)
            .option(USER, databaseProperties.username)
            .option(PASSWORD, databaseProperties.pass)
            .option(PoolingConnectionFactoryProvider.MAX_SIZE, databaseProperties.maxSize)
            .build())

    @Bean
    override fun connectionFactory(): ConnectionFactory {
        return ConnectionPool(ConnectionPoolConfiguration.builder(connectionFactory)
                .validationQuery(databaseProperties.validationQuery)
                .initialSize(databaseProperties.initializeSize)
                .maxIdleTime(Duration.ofMinutes(databaseProperties.maxIdleTime))
                .maxSize(databaseProperties.maxSize)
                .build())
    }

    @Bean
    fun transactionManager(): R2dbcTransactionManager {
        return R2dbcTransactionManager(connectionFactory)
    }

    @Bean
    fun databaseClient(): DatabaseClient {
        return DatabaseClient.create(connectionFactory())
    }

    @Bean
    fun r2dbcEntityOperations(): R2dbcEntityOperations {
        return R2dbcEntityTemplate(databaseClient())
    }

    @Bean
    override fun r2dbcCustomConversions(): R2dbcCustomConversions {
        val converters: MutableList<Converter<*, *>?> = ArrayList()
        converters.add(UUIDConverter())
        /*   converters.add(JsonToMapConverter(objectMapper))
           converters.add(MapToJsonConverter(objectMapper))
        */   return R2dbcCustomConversions(storeConversions, converters)
    }

    @Bean
    fun transactionOperator(transactionManager: R2dbcTransactionManager): TransactionalOperator {
        return TransactionalOperator.create(transactionManager)
    }

    @Bean
    fun chromeWebDriver(): ChromeDriver {
        val chromeOptions = ChromeOptions()
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER)
        return ChromeDriver(chromeOptions)
    }

    @Bean
    fun headers() : HttpHeaders {
        val headers = HttpHeaders()
        headers.add("User-Agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:84.0) Gecko/20100101 Firefox/84.0")
        headers.add("Accept", " application/json, text/javascript, */*; q=0.01")
        headers.add("Accept-Language", " en-US,en;q=0.5")
        headers.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
        headers.add("X-XSRF-TOKEN", " ada08cb7-0474-4876-868c-00b6cd16c454")
        headers.add("X-Requested-With", " XMLHttpRequest")
        headers.add("Origin", " https://www.copart.com")
        headers.add("Connection", " keep-alive")
        headers.add("TE", " Trailers")
        headers.add("Cookie", StringUtils.EMPTY)

        return headers
    }

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }

    @Bean
    fun objectMapper() : ObjectMapper {
        return ObjectMapper()
    }

    @Bean
    fun modelMapper() : ModelMapper {
        return ModelMapper()
    }

}

