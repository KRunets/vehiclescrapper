package by.runets.vehiclescrapper.scrapper.copart.processor

interface IScrapperProcessor<T> {
    suspend fun scrap(): T?

    fun scrapByCriteria(criteria: Map<String, Any>?): Set<T>
}