package by.runets.vehiclescrapper.scrapper.copart.provider.impl

import by.runets.vehiclescrapper.scrapper.copart.provider.IScrapper

abstract class AbstractScrapper<T> : IScrapper<T> {
    override suspend fun scrap(): T? {
        TODO("not implemented")
    }

    override fun scrapByCriteria(criteria: Map<String, Any>?): Set<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}