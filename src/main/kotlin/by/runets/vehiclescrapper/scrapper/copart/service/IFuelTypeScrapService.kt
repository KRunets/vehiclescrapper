package by.runets.vehiclescrapper.scrapper.copart.service

interface IFuelTypeScrapService {
    suspend fun scrapAndSave()

    suspend fun scrapAndSaveByMake(make: String)
}