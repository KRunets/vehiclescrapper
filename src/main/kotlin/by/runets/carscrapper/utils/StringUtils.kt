package by.runets.carscrapper.utils

class StringUtils {
    companion object {
        fun replaceDash(string: String): String {
            if (string.contains("-")) {
                var result = ""
                val arr = string.split("-")
                for (i in arr) {
                    result += i
                }
                return result
            }
            return string
        }
    }
}