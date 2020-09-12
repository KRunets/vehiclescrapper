package by.runets.carscrapper.scrapper.copart.provider

interface IScrapper<T> {
    suspend fun scrap(): T?
}