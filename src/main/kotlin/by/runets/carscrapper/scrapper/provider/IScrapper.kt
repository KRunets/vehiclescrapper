package by.runets.carscrapper.scrapper.provider

interface IScrapper <T> {
    fun scrap(page: String) : Set<T>
}