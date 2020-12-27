package by.runets.vehiclescrapper.scrapper.copart.utils

import org.openqa.selenium.Cookie
import org.springframework.http.HttpHeaders

class HttpUtils {
    companion object {

        val FIRST_VEHICLE = "1"

        val MAKE_KEY = "{{MAKE}}"
        val SIZE_KEY = "{{SIZE}}"
        val LOT_NUMBER = "{{LOT_NUMBER}}"

        val LOTS_SEARCH = "https://www.copart.com/public/lots/search"
        val LOT_SEARCH = "https://www.copart.com/public/data/lotdetails/solr/{{LOT_NUMBER}}"

        val BODY =
                "draw=1&columns%5B0%5D%5Bdata%5D=0&columns%5B0%5D%5Bname%5D=" +
                "&columns%5B0%5D%5Bsearchable%5D=true" +
                "&columns%5B0%5D%5Borderable%5D=false" +
                "&columns%5B0%5D%5Bsearch%5D%5Bvalue%5D=" +
                "&columns%5B0%5D%5Bsearch%5D%5Bregex%5D=false" +
                "&columns%5B1%5D%5Bdata%5D=1" +
                "&columns%5B1%5D%5Bname%5D=" +
                "&columns%5B1%5D%5Bsearchable%5D=true" +
                "&columns%5B1%5D%5Borderable%5D=false" +
                "&columns%5B1%5D%5Bsearch%5D%5Bvalue%5D=" +
                "&columns%5B1%5D%5Bsearch%5D%5Bregex%5D=false" +
                "&columns%5B2%5D%5Bdata%5D=2" +
                "&columns%5B2%5D%5Bname%5D=" +
                "&columns%5B2%5D%5Bsearchable%5D=true" +
                "&columns%5B2%5D%5Borderable%5D=true" +
                "&columns%5B2%5D%5Bsearch%5D%5Bvalue%5D=" +
                "&columns%5B2%5D%5Bsearch%5D%5Bregex%5D=false" +
                "&columns%5B3%5D%5Bdata%5D=3" +
                "&columns%5B3%5D%5Bname%5D=" +
                "&columns%5B3%5D%5Bsearchable%5D=true" +
                "&columns%5B3%5D%5Borderable%5D=true" +
                "&columns%5B3%5D%5Bsearch%5D%5Bvalue%5D=" +
                "&columns%5B3%5D%5Bsearch%5D%5Bregex%5D=false" +
                "&columns%5B4%5D%5Bdata%5D=4" +
                "&columns%5B4%5D%5Bname%5D=" +
                "&columns%5B4%5D%5Bsearchable%5D=true" +
                "&columns%5B4%5D%5Borderable%5D=true" +
                "&columns%5B4%5D%5Bsearch%5D%5Bvalue%5D=" +
                "&columns%5B4%5D%5Bsearch%5D%5Bregex%5D=false" +
                "&columns%5B5%5D%5Bdata%5D=5" +
                "&columns%5B5%5D%5Bname%5D=" +
                "&columns%5B5%5D%5Bsearchable%5D=true" +
                "&columns%5B5%5D%5Borderable%5D=true" +
                "&columns%5B5%5D%5Bsearch%5D%5Bvalue%5D=" +
                "&columns%5B5%5D%5Bsearch%5D%5Bregex%5D=false" +
                "&columns%5B6%5D%5Bdata%5D=6" +
                "&columns%5B6%5D%5Bname%5D=" +
                "&columns%5B6%5D%5Bsearchable%5D=true" +
                "&columns%5B6%5D%5Borderable%5D=true" +
                "&columns%5B6%5D%5Bsearch%5D%5Bvalue%5D=" +
                "&columns%5B6%5D%5Bsearch%5D%5Bregex%5D=false" +
                "&columns%5B7%5D%5Bdata%5D=7" +
                "&columns%5B7%5D%5Bname%5D=" +
                "&columns%5B7%5D%5Bsearchable%5D=true" +
                "&columns%5B7%5D%5Borderable%5D=true" +
                "&columns%5B7%5D%5Bsearch%5D%5Bvalue%5D=" +
                "&columns%5B7%5D%5Bsearch%5D%5Bregex%5D=false" +
                "&columns%5B8%5D%5Bdata%5D=8&columns%5B8%5D%5Bname%5D=" +
                "&columns%5B8%5D%5Bsearchable%5D=true" +
                "&columns%5B8%5D%5Borderable%5D=true" +
                "&columns%5B8%5D%5Bsearch%5D%5Bvalue%5D=" +
                "&columns%5B8%5D%5Bsearch%5D%5Bregex%5D=false" +
                "&columns%5B9%5D%5Bdata%5D=9" +
                "&columns%5B9%5D%5Bname%5D=" +
                "&columns%5B9%5D%5Bsearchable%5D=true" +
                "&columns%5B9%5D%5Borderable%5D=true" +
                "&columns%5B9%5D%5Bsearch%5D%5Bvalue%5D=" +
                "&columns%5B9%5D%5Bsearch%5D%5Bregex%5D=false" +
                "&columns%5B10%5D%5Bdata%5D=10" +
                "&columns%5B10%5D%5Bname%5D=" +
                "&columns%5B10%5D%5Bsearchable%5D=true" +
                "&columns%5B10%5D%5Borderable%5D=true" +
                "&columns%5B10%5D%5Bsearch%5D%5Bvalue%5D=" +
                "&columns%5B10%5D%5Bsearch%5D%5Bregex%5D=false" +
                "&columns%5B11%5D%5Bdata%5D=11" +
                "&columns%5B11%5D%5Bname%5D=" +
                "&columns%5B11%5D%5Bsearchable%5D=true" +
                "&columns%5B11%5D%5Borderable%5D=true" +
                "&columns%5B11%5D%5Bsearch%5D%5Bvalue%5D=" +
                "&columns%5B11%5D%5Bsearch%5D%5Bregex%5D=false" +
                "&columns%5B12%5D%5Bdata%5D=12" +
                "&columns%5B12%5D%5Bname%5D=" +
                "&columns%5B12%5D%5Bsearchable%5D=true" +
                "&columns%5B12%5D%5Borderable%5D=true" +
                "&columns%5B12%5D%5Bsearch%5D%5Bvalue%5D=" +
                "&columns%5B12%5D%5Bsearch%5D%5Bregex%5D=false" +
                "&columns%5B13%5D%5Bdata%5D=13" +
                "&columns%5B13%5D%5Bname%5D=" +
                "&columns%5B13%5D%5Bsearchable%5D=true" +
                "&columns%5B13%5D%5Borderable%5D=true" +
                "&columns%5B13%5D%5Bsearch%5D%5Bvalue%5D=" +
                "&columns%5B13%5D%5Bsearch%5D%5Bregex%5D=false" +
                "&columns%5B14%5D%5Bdata%5D=14&columns%5B14%5D%5Bname%5D=" +
                "&columns%5B14%5D%5Bsearchable%5D=true&columns%5B14%5D%5Borderable%5D=false" +
                "&columns%5B14%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B14%5D%5Bsearch%5D%5Bregex%5D=false" +
                "&columns%5B15%5D%5Bdata%5D=15&columns%5B15%5D%5Bname%5D=" +
                "&columns%5B15%5D%5Bsearchable%5D=true" +
                "&columns%5B15%5D%5Borderable%5D=false" +
                "&columns%5B15%5D%5Bsearch%5D%5Bvalue%5D=" +
                "&columns%5B15%5D%5Bsearch%5D%5Bregex%5D=false" +
                "&order%5B0%5D%5Bcolumn%5D=1" +
                "&order%5B0%5D%5Bdir%5D=asc&start=0" +
                "&length=20&search%5Bvalue%5D=" +
                "&search%5Bregex%5D=false" +
                "&sort=auction_date_type+desc%2Cauction_date_utc+asc" +
                "&defaultSort=true&filter%5BMISC%5D=" +
                "lot_make_desc%3A{{MAKE}}&query=*" +
                "&watchListOnly=false" +
                "&freeFormSearch=false" +
                "&page=0&size={{SIZE}}"


        /*filter%5BMISC%5D=lot_make_desc%3AAUDI
&filter%5BMODL%5D=lot_model_desc%3A%22{{MODEL}}%22
&filter%5BYEAR%5D=lot_year%3A%22{{YEAR}}%22
&filter%5BPRID%5D=damage_type_code%3ADAMAGECODE_FR
&filter%5BFUEL%5D=fuel_type_desc%3A%22{{FUEL}}%22
&filter%5BENGN%5D=engine%3A%22{{ENGN}}++4%22
&filter%5BTMTP%5D=transmission_type%3A%22{{TRANSMISSION}}%22
&filter%5BDRIV%5D=drive%3A%22{{DDTP}}%22
&filter%5BCYLN%5D=cylinders%3A%22{{CYLINDRES}}%22
&query=*&watchListOnly=false&freeFormSearch=false
&page=0&size=20
&includeTagByField%5BYEAR%5D=%7B!tag%3DYEAR%7D
&includeTagByField%5BODM%5D=%7B!tag%3DODM%7D+
&includeTagByField%5BSLOC%5D=%7B!tag%3DSLOC%7D
&includeTagByField%5BPRID%5D=%7B!tag%3DPRID%7D
&includeTagByField%5BFUEL%5D=%7B!tag%3DFUEL%7D
&includeTagByField%5BENGN%5D=%7B!tag%3DENGN%7D
&includeTagByField%5BTMTP%5D=%7B!tag%3DTMTP%7D
&includeTagByField%5BDRIV%5D=%7B!tag%3DDRIV%7D
&includeTagByField%5BCYLN%5D=%7B!tag%3DCYLN%7D*/

        fun updateCookieInHeaders(headers: HttpHeaders, value : String?) {
            headers.remove("Cookie")
            headers.add("Cookie", value)
        }

        fun inlineCookies(cookies : Collection<Cookie>) : String {
            var resString = " "

            var i = 0;
            val cookiesList = cookies.toList()
            while (++i < cookiesList.size) {
                val cookie = cookiesList[i]
                resString += cookie.name + "=" + cookie.value +  "; "
            }

            val lastCookie = cookiesList[cookiesList.size - 1]
            resString += lastCookie.name + "=" + lastCookie.value

            return resString
        }
    }
}