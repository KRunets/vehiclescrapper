package by.runets.carscrapper.scrapper.copart.service.impl

import by.runets.carscrapper.scrapper.copart.service.IScrapService

abstract class AbstractScrapService<T> : IScrapService<T>{
    override suspend fun scrapAndSave(): T {
        TODO("not implemented")
    }
}