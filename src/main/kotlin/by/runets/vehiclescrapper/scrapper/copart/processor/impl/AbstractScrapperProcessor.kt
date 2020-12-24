package by.runets.vehiclescrapper.scrapper.copart.processor.impl

import by.runets.vehiclescrapper.scrapper.copart.processor.IScrapperProcessor

abstract class AbstractScrapperProcessor<T> : IScrapperProcessor<T> {
    override suspend fun scrap(): T? {
        TODO("not implemented")
    }

    override suspend fun scrap(criteria: Map<String, Any>?): T? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun scrapAll(criteria: Map<String, Any>?): Set<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}