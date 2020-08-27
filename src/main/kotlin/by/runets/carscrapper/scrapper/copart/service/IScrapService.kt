package by.runets.carscrapper.scrapper.copart.service

interface IScrapService <T> {
    suspend fun scrapAndSave()
}