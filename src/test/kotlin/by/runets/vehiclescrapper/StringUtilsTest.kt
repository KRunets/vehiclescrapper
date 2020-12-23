package by.runets.vehiclescrapper

import by.runets.vehiclescrapper.utils.StringUtils
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.JsonParser
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import org.testcontainers.shaded.com.fasterxml.jackson.databind.JsonNode
import java.io.InputStreamReader


class StringUtilsTest {

    private val restTemplate = RestTemplate()
    private val mapper: ObjectMapper = ObjectMapper()

      @Test
    fun test2() {

        val headers = HttpHeaders()

        headers.add("User-Agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:84.0) Gecko/20100101 Firefox/84.0")
        headers.add("Accept", " application/json, text/javascript, */*; q=0.01")
        headers.add("Accept-Language", " en-US,en;q=0.5")
        headers.add("X-XSRF-TOKEN", " ada08cb7-0474-4876-868c-00b6cd16c454")
        headers.add("X-Requested-With", " XMLHttpRequest")
        headers.add("Origin", " https://www.copart.com")
        headers.add("Connection", " keep-alive")
        headers.add("Referer", " https://www.copart.com/vehicleFinderSearch/?displayStr=")
        headers.add("Cookie", " visid_incap_242093=iSHdEEGAQz+3+p+B6pWtAnJ+mF8AAAAAQkIPAAAAAACAORiZASXXJPP9Jw4vmCe5jauHj+9rz3pf; _gcl_au=1.1.1962662866.1603829364; _ga=GA1.1.611765614.1603829365; s_fid=567A8DB345415B49-2FF508D7B2590FE8; s_nr=1608657662979-Repeat; s_lv=1608657662981; s_vi=[CS]v1|2FCC3F3C05159313-40000965E02788E0[CE]; OAID=80d2f76bcaa773181d4080bda25d3333; __gads=ID=76eea2e189c7d020-220a58c81cb9006b:T=1604218700:S=ALNI_MYJ2x70GpAsvImVUfU9Ipic1pQLUw; _fbp=fb.1.1603829370096.1150901323; _gaexp=GAX1.2.aiK59hBiT8eLj9AzHvgpbg.18706.2; s_vnum=1609785928327")
        headers.add("TE", " Trailers")
        headers.add("Cache-Control", "no-cache")
        headers.add("Accept-Encoding", "gzip, deflate, br")
        headers.add("X-XSS-Protection", "1; mode=block")

        val requestEntity: HttpEntity<String> = HttpEntity<String>("draw=1&columns", headers)

        val responseEntity: ResponseEntity<String> = restTemplate.exchange("https://www.copart.com/public/vehicleFinder/search", HttpMethod.POST, requestEntity, String::class.java)

    }

    @Test
    fun test3() {
        val headers = HttpHeaders()

        headers.add("User-Agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:84.0) Gecko/20100101 Firefox/84.0")
        headers.add("Accept", " application/json, text/javascript, */*; q=0.01")
        headers.add("Accept-Language", " ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
        headers.add("X-XSRF-TOKEN", " e4f2dc64-eb09-44dd-b4ac-062bed048d97")
        headers.add("X-Requested-With", " XMLHttpRequest")
        headers.add("Origin", " https://www.copart.com")
        headers.add("Connection", " keep-alive")
        headers.add("Cookie", " g2usersessionid=7d90a88ea25ffafd5ad77a7459772725; G2JSESSIONID=8B42BFC4967B9C981EF3E72A9C49B190-n2; userLang=en; visid_incap_242093=CMH0mbusRkqtFQqWvEyZYndU418AAAAAQUIPAAAAAABDnBLwB55A97CpU8XDzQFU; incap_ses_473_242093=DMkkJcSuDlqPIXQEO2+QBnhU418AAAAA0XV3pxuoGFs8NQrB1Krdhg==; copartTimezonePref=")
        headers.add("TE", " Trailers")

        val requestEntity = HttpEntity("draw=1&columns", headers)
        val responseEntity = restTemplate.exchange("https://www.copart.com/public/lots/search", HttpMethod.POST, requestEntity, String::class.java)
    }

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