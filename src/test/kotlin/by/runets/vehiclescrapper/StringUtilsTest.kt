package by.runets.vehiclescrapper

import by.runets.vehiclescrapper.utils.StringUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import org.testcontainers.shaded.com.fasterxml.jackson.databind.JsonNode


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
          println(responseEntity)

    }

    @Test
    fun test3() {
        val headers = HttpHeaders()

        headers.add("User-Agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:84.0) Gecko/20100101 Firefox/84.0")
        headers.add("Accept", " application/json, text/javascript, */*; q=0.01")
        headers.add("Accept-Language", " ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
        headers.add("X-XSRF-TOKEN", " 31a829ad-5a1a-4bf4-ba1d-da91cb3cb9af")
        headers.add("X-Requested-With", " XMLHttpRequest")
        headers.add("Origin", " https://www.copart.com")
        headers.add("Connection", " keep-alive")
        headers.add("Referer", " https://www.copart.com/vehicleFinderSearch/?displayStr=")
        headers.add("Cookie", " G2JSESSIONID=0A9C046C0F93A364918E9A2B325A2B0F-n2; userLang=en; visid_incap_242093=CMH0mbusRkqtFQqWvEyZYndU418AAAAAQUIPAAAAAABDnBLwB55A97CpU8XDzQFU; incap_ses_473_242093=0idCWwPbxkn8Yj0FO2+QBitT5F8AAAAAGM/eNM6PBKB9JJcvIsyxYA==; copartTimezonePref=")
        headers.add("TE", " Trailers")

        val requestEntity = HttpEntity("draw=1&columns", headers)

        val responseEntity = restTemplate.exchange("https://www.copart.com/public/vehicleFinder/search", HttpMethod.POST, requestEntity, String::class.java)

        println(responseEntity)
    }

    @Test
    fun fun_testReplace() {
        val inlineCookies = "curl \"https://www.copart.com/public/lots/search\" -H \"User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:84.0) Gecko/20100101 Firefox/84.0\" -H \"Accept: application/json, text/javascript, */*; q=0.01\" -H \"Accept-Language: ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3\" --compressed -H \"Content-Type: application/x-www-form-urlencoded; charset=UTF-8\" -H \"X-XSRF-TOKEN: 31a829ad-5a1a-4bf4-ba1d-da91cb3cb9af\" -H \"X-Requested-With: XMLHttpRequest\" -H \"Origin: https://www.copart.com\" -H \"Connection: keep-alive\" -H \"Referer: https://www.copart.com/search/audi/?displayStr=Audi&from=\"%\"2FvehicleFinder\" -H \"Cookie: G2JSESSIONID=0A9C046C0F93A364918E9A2B325A2B0F-n2; userLang=en; visid_incap_242093=CMH0mbusRkqtFQqWvEyZYndU418AAAAAQUIPAAAAAABDnBLwB55A97CpU8XDzQFU; incap_ses_473_242093=0idCWwPbxkn8Yj0FO2+QBitT5F8AAAAAGM/eNM6PBKB9JJcvIsyxYA==; copartTimezonePref=\"%\"7B\"%\"22displayStr\"%\"22\"%\"3A\"%\"22MSK\"%\"22\"%\"2C\"%\"22offset\"%\"22\"%\"3A3\"%\"2C\"%\"22dst\"%\"22\"%\"3Afalse\"%\"2C\"%\"22windowsTz\"%\"22\"%\"3A\"%\"22Europe\"%\"2FMinsk\"%\"22\"%\"7D; timezone=Europe\"%\"2FMinsk; g2app.locationInfo=\"%\"7B\"%\"22countryCode\"%\"22\"%\"3A\"%\"22BLR\"%\"22\"%\"2C\"%\"22countryName\"%\"22\"%\"3A\"%\"22Belarus\"%\"22\"%\"2C\"%\"22stateName\"%\"22\"%\"3A\"%\"22Minskaya\"%\"20voblasts'\"%\"22\"%\"2C\"%\"22cityName\"%\"22\"%\"3A\"%\"22Minsk\"%\"22\"%\"2C\"%\"22latitude\"%\"22\"%\"3A53.9\"%\"2C\"%\"22longitude\"%\"22\"%\"3A27.56667\"%\"2C\"%\"22zipCode\"%\"22\"%\"3A\"%\"22220088\"%\"22\"%\"2C\"%\"22timeZone\"%\"22\"%\"3A\"%\"22\"%\"2B02\"%\"3A00\"%\"22\"%\"7D; s_fid=77BD8320C534376B-19CD702B302801FE; s_nr=1608799303336-Repeat; s_vnum=1611325821200\"%\"26vn\"%\"3D2; s_lv=1608799303336; s_cc=true; s_vi=[CS]v1|2FF1AA3D0515978C-4000094D93271229[CE]; _gaexp=GAX1.2.aiK59hBiT8eLj9AzHvgpbg.18706.1; _fbp=fb.1.1608733822116.1435114531; _gcl_au=1.1.779092675.1608733822; _ga=GA1.2.1173816170.1608733822; _gid=GA1.2.1427640961.1608733822; _ga_WEF8SZZLJG=GS1.1.1608799021.2.1.1608799303.0; s_ppvl=member\"%\"253AsearchResults\"%\"2C31\"%\"2C12\"%\"2C832\"%\"2C1474\"%\"2C304\"%\"2C1536\"%\"2C864\"%\"2C1.25\"%\"2CP; s_ppv=public\"%\"253Avehiclefinder\"%\"2C35\"%\"2C12\"%\"2C832\"%\"2C1474\"%\"2C304\"%\"2C1536\"%\"2C864\"%\"2C1.25\"%\"2CP; s_sq=copart-g2-us-prod\"%\"3D\"%\"2526c.\"%\"2526a.\"%\"2526activitymap.\"%\"2526page\"%\"253Dpublic\"%\"25253Avehiclefinder\"%\"2526link\"%\"253DAudi\"%\"2526region\"%\"253DmainBody\"%\"2526pageIDType\"%\"253D1\"%\"2526.activitymap\"%\"2526.a\"%\"2526.c\"%\"2526pid\"%\"253Dpublic\"%\"25253Avehiclefinder\"%\"2526pidt\"%\"253D1\"%\"2526oid\"%\"253Dhttps\"%\"25253A\"%\"25252F\"%\"25252Fwww.copart.com\"%\"25252Fsearch\"%\"25252Faudi\"%\"25253FdisplayStr\"%\"25253DAudi\"%\"252526from\"%\"25253D\"%\"25252FvehicleFinder\"%\"2526ot\"%\"253DA; OAGEO=BY\"%\"7C\"%\"7C\"%\"7C\"%\"7C\"%\"7C\"%\"7C\"%\"7C\"%\"7C\"%\"7C\"%\"7C; OAID=a86108f8cd9303c38c162d86ec6167d4; __gads=ID=50e4752ec2ff2318-2266b79e70b900b2:T=1608733821:S=ALNI_MaswTU9trDx9Yc--0ibpFOQKegoBA; __cfduid=dac9cc109e25f1f8b765ff6c2854650f01608733824; g2usersessionid=0b4f61da6613900ecce840bc5d774668; s_depth=2; s_pv=public\"%\"3Avehiclefinder; s_invisit=true; s_lv_s=Less\"%\"20than\"%\"201\"%\"20day; usersessionid=1e4a3cac16ebec272c21cc19ed4e1f1e; _uetsid=63a69c10452b11eba92a2957f1231406; _uetvid=63a79250452b11eb8adb235063865577; _gat_UA-90930613-1=1\" -H \"TE: Trailers\" --data-raw \"draw=1&columns\"%\"5B0\"%\"5D\"%\"5Bdata\"%\"5D=0&columns\"%\"5B0\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B0\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B0\"%\"5D\"%\"5Borderable\"%\"5D=false&columns\"%\"5B0\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B0\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B1\"%\"5D\"%\"5Bdata\"%\"5D=1&columns\"%\"5B1\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B1\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B1\"%\"5D\"%\"5Borderable\"%\"5D=false&columns\"%\"5B1\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B1\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B2\"%\"5D\"%\"5Bdata\"%\"5D=2&columns\"%\"5B2\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B2\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B2\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B2\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B2\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B3\"%\"5D\"%\"5Bdata\"%\"5D=3&columns\"%\"5B3\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B3\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B3\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B3\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B3\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B4\"%\"5D\"%\"5Bdata\"%\"5D=4&columns\"%\"5B4\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B4\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B4\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B4\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B4\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B5\"%\"5D\"%\"5Bdata\"%\"5D=5&columns\"%\"5B5\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B5\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B5\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B5\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B5\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B6\"%\"5D\"%\"5Bdata\"%\"5D=6&columns\"%\"5B6\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B6\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B6\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B6\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B6\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B7\"%\"5D\"%\"5Bdata\"%\"5D=7&columns\"%\"5B7\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B7\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B7\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B7\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B7\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B8\"%\"5D\"%\"5Bdata\"%\"5D=8&columns\"%\"5B8\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B8\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B8\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B8\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B8\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B9\"%\"5D\"%\"5Bdata\"%\"5D=9&columns\"%\"5B9\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B9\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B9\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B9\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B9\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B10\"%\"5D\"%\"5Bdata\"%\"5D=10&columns\"%\"5B10\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B10\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B10\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B10\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B10\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B11\"%\"5D\"%\"5Bdata\"%\"5D=11&columns\"%\"5B11\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B11\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B11\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B11\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B11\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B12\"%\"5D\"%\"5Bdata\"%\"5D=12&columns\"%\"5B12\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B12\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B12\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B12\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B12\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B13\"%\"5D\"%\"5Bdata\"%\"5D=13&columns\"%\"5B13\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B13\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B13\"%\"5D\"%\"5Borderable\"%\"5D=true&columns\"%\"5B13\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B13\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B14\"%\"5D\"%\"5Bdata\"%\"5D=14&columns\"%\"5B14\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B14\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B14\"%\"5D\"%\"5Borderable\"%\"5D=false&columns\"%\"5B14\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B14\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&columns\"%\"5B15\"%\"5D\"%\"5Bdata\"%\"5D=15&columns\"%\"5B15\"%\"5D\"%\"5Bname\"%\"5D=&columns\"%\"5B15\"%\"5D\"%\"5Bsearchable\"%\"5D=true&columns\"%\"5B15\"%\"5D\"%\"5Borderable\"%\"5D=false&columns\"%\"5B15\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bvalue\"%\"5D=&columns\"%\"5B15\"%\"5D\"%\"5Bsearch\"%\"5D\"%\"5Bregex\"%\"5D=false&order\"%\"5B0\"%\"5D\"%\"5Bcolumn\"%\"5D=1&order\"%\"5B0\"%\"5D\"%\"5Bdir\"%\"5D=asc&start=0&length=20&search\"%\"5Bvalue\"%\"5D=&search\"%\"5Bregex\"%\"5D=false&sort=auction_date_type+desc\"%\"2Cauction_date_utc+asc&defaultSort=true&filter\"%\"5BMISC\"%\"5D=lot_make_desc\"%\"3AAUDI&query=*&watchListOnly=false&freeFormSearch=false&page=0&size=20\"\n"

        println(        inlineCookies.replace("size=20", "size=" + 100)
        )
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