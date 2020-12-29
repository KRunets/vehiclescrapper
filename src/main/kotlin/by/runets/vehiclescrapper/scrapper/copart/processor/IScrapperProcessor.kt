package by.runets.vehiclescrapper.scrapper.copart.processor

interface IScrapperProcessor<T> {
    suspend fun scrap(): T?

    suspend fun scrap(criteria: Map<String, Any>?): T?

    fun scrapAll(criteria: Map<String, Any>?): Set<T>
}