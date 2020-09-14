package by.runets.vehiclescrapper.scrapper.copart.service.impl

import by.runets.vehiclescrapper.scrapper.copart.service.IScrapService

abstract class AbstractScrapService<T> : IScrapService<T>{
    override suspend fun scrapAndSave(): T {
        TODO("not implemented")
    }
}