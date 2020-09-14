package by.runets.vehiclescrapper.utils

class StringUtils {
    companion object {
        fun replaceDash(string: String): String {
            val isContainsDash = string.contains("-")
            val isContainsPercentage = string.contains("%20")
            if (isContainsDash || isContainsPercentage) {
                var result = ""
                val arr = splitBy(isContainsDash, string)
                for (i in arr) {
                    result += i
                }
                return result
            }
            return string
        }

        private fun splitBy(isContainsDash: Boolean, string: String) : List<String> {
            return if (isContainsDash) string.split("-") else string.split("%20")
        }

    }
}