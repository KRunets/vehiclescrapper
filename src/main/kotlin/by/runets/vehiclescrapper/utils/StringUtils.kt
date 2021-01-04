package by.runets.vehiclescrapper.utils

class StringUtils {
    companion object {

        fun concat(string: String): String {
            val isContainsDash = string.contains("-")
            val isContainsPercentage = string.contains("%20")
            val isSplitted = string.contains(" ")
            if (isContainsDash || isContainsPercentage || isSplitted) {
                var result = ""
                val arr = splitBy(isContainsDash, isContainsPercentage, string)
                for (i in arr) {
                    result += i
                }
                return result
            }
            return string
        }

        private fun splitBy(isContainsDash: Boolean, isContainsPercentage: Boolean, string: String): List<String> {
            return when {
                isContainsDash -> string.split("-")
                isContainsPercentage -> string.split("%20")
                else -> string.split(" ")
            }
        }
    }
}