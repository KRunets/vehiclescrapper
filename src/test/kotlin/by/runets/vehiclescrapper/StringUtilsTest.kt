package by.runets.vehiclescrapper

import by.runets.vehiclescrapper.utils.StringUtils
import org.junit.Assert
import org.junit.jupiter.api.Test

class StringUtilsTest {

    @Test
    fun test_concatSplittedByEmpty() {
        val expected = "landrover"
        val actual = StringUtils.concat("land rover")

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun test_concatSplittedByEncodedEmpty() {
        val expected = "landrover"
        val actual = StringUtils.concat("land%20rover")

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun test_concatSplittedByDash() {
        val expected = "landrover"
        val actual = StringUtils.concat("land-rover")

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun test_shouldNotConcat() {
        val expected = "land.rover"
        val actual = StringUtils.concat("land.rover")

        Assert.assertEquals(expected, actual)
    }
}