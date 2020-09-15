package by.runets.vehiclescrapper.scrapper.copart.service

interface IEngineTypeScrapService {
    suspend fun scrapAndSave()

    suspend fun scrapAndSaveByMake(make: String)
}