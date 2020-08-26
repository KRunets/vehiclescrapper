package by.runets.carscrapper.utils

import com.gargoylesoftware.htmlunit.BrowserVersion
import com.gargoylesoftware.htmlunit.WebClient
import com.gargoylesoftware.htmlunit.html.HtmlPage

class UtilWebClient {
    companion object {
        fun loadPageByUrl(url: String): HtmlPage? {
            var page: HtmlPage? = null
            var webClient = WebClient(BrowserVersion.CHROME);
            try {
                page = webClient.getPage(url)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                webClient.close()
            }
            return page
        }
    }

}