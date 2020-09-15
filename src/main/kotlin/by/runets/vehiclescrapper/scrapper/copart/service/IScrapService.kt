package by.runets.vehiclescrapper.scrapper.copart.service

interface IScrapService<T> {
    suspend fun scrapAndSave(): T
}