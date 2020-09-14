package by.runets.vehiclescrapper.scrapper.copart.provider

interface IScrapper<T> {
    suspend fun scrap(): T?
}