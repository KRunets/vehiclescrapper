package by.runets.carscrapper

import by.runets.carscrapper.initializer.ContextInitializer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension


@SpringBootTest
@ExtendWith(SpringExtension::class)
@ContextConfiguration(initializers = [ContextInitializer::class])
class CarscrapperApplicationTests {

    @Test
    fun `findAll`() {
        var testVar: Boolean = true;
        assert(testVar)
    }

}
