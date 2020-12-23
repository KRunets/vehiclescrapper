package by.runets.vehiclescrapper.utils

import org.openqa.selenium.Cookie

class HttpUtils {
    companion object {

        fun inlineCookies(cookies : Set<Cookie>) : String {
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