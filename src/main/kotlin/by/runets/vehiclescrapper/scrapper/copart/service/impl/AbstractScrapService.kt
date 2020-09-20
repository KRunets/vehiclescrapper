package by.runets.vehiclescrapper.scrapper.copart.service.impl

import by.runets.vehiclescrapper.scrapper.copart.service.IScrapService

abstract class AbstractScrapService<T> : IScrapService<T> {
    override suspend fun scrapAndSave(): T {
        TODO("not implemented")
    }

    override suspend fun scrapAndSaveVoid() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun scrapAndSaveByMake(make: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}