package by.runets.vehiclescrapper.scrapper.copart.service


interface IScrapService<T> {
    suspend fun scrapAndSave(): T

    suspend fun scrapAndSaveVoid()

    suspend fun scrapAndSaveByMake(make: String)
}