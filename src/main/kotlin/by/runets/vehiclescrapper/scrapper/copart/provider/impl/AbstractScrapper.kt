package by.runets.vehiclescrapper.scrapper.copart.provider.impl

import by.runets.vehiclescrapper.scrapper.copart.provider.IScrapper

abstract class AbstractScrapper<T, C> : IScrapper<T, C> {
    override suspend fun scrap(): T? {
        TODO("not implemented")
    }

    override fun scrapByCriteria(criteria: C): Set<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}