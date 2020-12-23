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
        val jsonNode: JsonNode = mapper.readValue(responseEntity.body, JsonNode::class.java)

    }

    @Test
    fun test() {
        val reader = InputStreamReader(Runtime.getRuntime().exec("curl \"https://www.copart.com/public/vehicleFinder/search\" -H \"User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:84.0) Gecko/20100101 Firefox/84.0\" -H \"Accept: application/json, text/javascript, */*; q=0.01\" -H \"Accept-Language: en-US,en;q=0.5\" --compressed -H \"Content-Type: application/x-www-form-urlencoded; charset=UTF-8\" -H \"X-XSRF-TOKEN: a0cabd66-6ad4-43ba-9450-93fdd5b09131\" -H \"X-Requested-With: XMLHttpRequest\" -H \"Origin: https://www.copart.com\" -H \"Connection: keep-alive\" -H \"Referer: https://www.copart.com/vehicleFinder/\" -H \"Cookie: visid_incap_242093=iSHdEEGAQz+3+p+B6pWtAnJ+mF8AAAAAQkIPAAAAAACAORiZASXXJPP9Jw4vmCe5jauHj+9rz3pf; _gcl_au=1.1.1962662866.1603829364; _ga=GA1.2.611765614.1603829365; s_fid=567A8DB345415B49-2FF508D7B2590FE8; s_nr=1608634859896-Repeat; s_lv=1608634859897; s_vi=[CS]v1|2FCC3F3C05159313-40000965E02788E0[CE]; OAID=80d2f76bcaa773181d4080bda25d3333; __gads=ID=76eea2e189c7d020-220a58c81cb9006b:T=1604218700:S=ALNI_MYJ2x70GpAsvImVUfU9Ipic1pQLUw; _fbp=fb.1.1603829370096.1150901323; _gaexp=GAX1.2.aiK59hBiT8eLj9AzHvgpbg.18706.2; s_vnum=1609785928327\"%\"26vn\"%\"3D10; _ga_WEF8SZZLJG=GS1.1.1608633541.10.1.1608634860.0; __pdst=77c3cce363bb476780021a1c7e0859c0; __cfduid=ded9f168ebf94a157d85a4503b5ccb92a1607194001; g2app.locationInfo=\"%\"7B\"%\"22countryCode\"%\"22\"%\"3A\"%\"22BLR\"%\"22\"%\"2C\"%\"22countryName\"%\"22\"%\"3A\"%\"22Belarus\"%\"22\"%\"2C\"%\"22stateName\"%\"22\"%\"3A\"%\"22Minskaya\"%\"20voblasts'\"%\"22\"%\"2C\"%\"22cityName\"%\"22\"%\"3A\"%\"22Minsk\"%\"22\"%\"2C\"%\"22latitude\"%\"22\"%\"3A53.9\"%\"2C\"%\"22longitude\"%\"22\"%\"3A27.56667\"%\"2C\"%\"22zipCode\"%\"22\"%\"3A\"%\"22220088\"%\"22\"%\"2C\"%\"22timeZone\"%\"22\"%\"3A\"%\"22\"%\"2B02\"%\"3A00\"%\"22\"%\"7D; _gid=GA1.2.1145790451.1608489200; G2JSESSIONID=5C2EF6E404AD7C6EA8C012B8276014C0-n2; userLang=en; incap_ses_473_242093=UR9/KnljZisrgvwCO2+QBsbM4V8AAAAADawJx3ASBECJJSGbpr2s8Q==; copartTimezonePref=\"%\"7B\"%\"22displayStr\"%\"22\"%\"3A\"%\"22MSK\"%\"22\"%\"2C\"%\"22offset\"%\"22\"%\"3A3\"%\"2C\"%\"22dst\"%\"22\"%\"3Afalse\"%\"2C\"%\"22windowsTz\"%\"22\"%\"3A\"%\"22Europe\"%\"2FMinsk\"%\"22\"%\"7D; timezone=Europe\"%\"2FMinsk; s_sq=\"%\"5B\"%\"5BB\"%\"5D\"%\"5D; s_ppvl=member\"%\"253AsearchResults\"%\"2C29\"%\"2C29\"%\"2C762\"%\"2C1473\"%\"2C762\"%\"2C1536\"%\"2C864\"%\"2C1.25\"%\"2CP; s_ppv=public\"%\"253Avehiclefinder\"%\"2C36\"%\"2C36\"%\"2C915\"%\"2C1473\"%\"2C467\"%\"2C1536\"%\"2C864\"%\"2C1.25\"%\"2CP; s_cc=true; OAGEO=BY\"%\"7C\"%\"7C\"%\"7C\"%\"7C\"%\"7C\"%\"7C\"%\"7C\"%\"7C\"%\"7C\"%\"7C; g2usersessionid=b059377eb1fae1b858f4e810aca4e1db; usersessionid=79423db72fe159b4ef3a425b9e423f26; g2app.searchResultsPageLength=10; s_pv=public\"%\"3Avehiclefinder; s_invisit=true; s_lv_s=Less\"%\"20than\"%\"201\"%\"20day; s_depth=5; _uetsid=d507875042f111ebbb202b2e8af4f010; _uetvid=4ef3cbc0189011ebaf677dc1eae0f805; _gat_UA-90930613-1=1\" -H \"TE: Trailers\" --data-raw \"draw=1&columns\"%\"5B0\"%\"5D\"%\"5Bdata\"%\"5D=0&columns\"%\"5B0\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B0\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B0\"%\"5D\"%\"5Borderable\"%\"5D=false&columns\"%\"5B0\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B0\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B1\"%\"5D\"%\"5Bdata\"%\"5D=1&columns\"%\"5B1\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B1\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B1\"%\"5D\"%\"5Borderable\"%\"5D=false&columns\"%\"5B1\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B1\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B2\"%\"5D\"%\"5Bdata\"%\"5D=2&columns\"%\"5B2\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B2\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B2\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B2\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B2\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B3\"%\"5D\"%\"5Bdata\"%\"5D=3&columns\"%\"5B3\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B3\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B3\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B3\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B3\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B4\"%\"5D\"%\"5Bdata\"%\"5D=4&columns\"%\"5B4\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B4\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B4\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B4\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B4\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B5\"%\"5D\"%\"5Bdata\"%\"5D=5&columns\"%\"5B5\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B5\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B5\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B5\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B5\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B6\"%\"5D\"%\"5Bdata\"%\"5D=6&columns\"%\"5B6\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B6\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B6\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B6\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B6\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B7\"%\"5D\"%\"5Bdata\"%\"5D=7&columns\"%\"5B7\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B7\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B7\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B7\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B7\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B8\"%\"5D\"%\"5Bdata\"%\"5D=8&columns\"%\"5B8\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B8\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B8\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B8\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B8\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B9\"%\"5D\"%\"5Bdata\"%\"5D=9&columns\"%\"5B9\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B9\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B9\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B9\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B9\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B10\"%\"5D\"%\"5Bdata\"%\"5D=10&columns\"%\"5B10\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B10\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B10\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B10\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B10\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B11\"%\"5D\"%\"5Bdata\"%\"5D=11&columns\"%\"5B11\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B11\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B11\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B11\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B11\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B12\"%\"5D\"%\"5Bdata\"%\"5D=12&columns\"%\"5B12\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B12\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B12\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B12\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B12\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B13\"%\"5D\"%\"5Bdata\"%\"5D=13&columns\"%\"5B13\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B13\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B13\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B13\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B13\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B14\"%\"5D\"%\"5Bdata\"%\"5D=14&columns\"%\"5B14\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B14\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B14\"%\"5D\"%\"5Borderable\"%\"5D=false&columns\"%\"5B14\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B14\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B15\"%\"5D\"%\"5Bdata\"%\"5D=15&columns\"%\"5B15\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B15\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B15\"%\"5D\"%\"5Borderable\"%\"5D=false&columns\"%\"5B15\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B15\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&order\"%\"5B0\"%\"5D\"%\"5Bcolumn\"%\"5D=1&order\"%\"5B0\"%\"5D\"%\"5Bdir\"%\"5D=asc&start=0&length=10&search\"%\"5Bvalue\"%\"5D=&search\"%\"5Bregex\"%\"5D=false&sort=auction_date_type+desc\"%\"2Cauction_date_utc+asc&defaultSort=true&filter\"%\"5BMISC\"%\"5D=\"%\"23VehicleTypeCode\"%\"3AVEHTYPE_V\"%\"2C\"%\"23LotYear\"%\"3A\"%\"5B2010+TO+2021\"%\"5D&query=*&watchListOnly=false&freeFormSearch=false&page=0&size=10\"").getInputStream())
        val element = JsonParser.parseReader(reader);
        println(element)
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