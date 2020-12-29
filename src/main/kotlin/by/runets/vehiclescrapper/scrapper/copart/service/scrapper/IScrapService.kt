package by.runets.vehiclescrapper.scrapper.copart.service.scrapper


interface IScrapService<T> {
    suspend fun scrapAndSave(): T

    suspend fun scrapAndSaveVoid()

    suspend fun scrapAndSaveByCriteria(searchCriteria : Map<String, Any>)

    suspend fun scrapAndSaveByMake(make: String)
}