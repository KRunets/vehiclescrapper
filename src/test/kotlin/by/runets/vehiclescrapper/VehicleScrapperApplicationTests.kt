package by.runets.vehiclescrapper

import by.runets.vehiclescrapper.initializer.ContextInitializer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension


@SpringBootTest
@ExtendWith(SpringExtension::class)
@ContextConfiguration(initializers = [ContextInitializer::class])
class VehicleScrapperApplicationTests {

    @Test
    fun `findAll`() {
        var testVar: Boolean = true;
        assert(testVar)
    }

}
