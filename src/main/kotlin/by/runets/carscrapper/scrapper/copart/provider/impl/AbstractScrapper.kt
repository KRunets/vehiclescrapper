package by.runets.carscrapper.scrapper.copart.provider.impl

import by.runets.carscrapper.scrapper.copart.provider.IScrapper

abstract class AbstractScrapper<T> : IScrapper<T> {
    override suspend fun scrap(): T? {
        TODO("not implemented")
    }
}