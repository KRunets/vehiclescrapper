package by.runets.vehiclescrapper.scrapper.copart.processor.impl

import by.runets.vehiclescrapper.scrapper.copart.processor.IScrapperProcessor

abstract class AbstractScrapperProcessor<T> : IScrapperProcessor<T> {
    override suspend fun scrap(): T? {
        TODO("not implemented")
    }

    override fun scrapByCriteria(criteria: Map<String, Any>?): Set<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}