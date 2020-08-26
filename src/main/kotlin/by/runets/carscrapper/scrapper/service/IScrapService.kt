package by.runets.carscrapper.scrapper.service

interface IScrapService <T> {
    suspend fun scrapAndSave()
}