package by.runets.vehiclescrapper.scrapper.copart.provider

interface IScrapper<T> {
    suspend fun scrap(): T?

    fun scrapByCriteria(criteria: Map<String, Any>?): Set<T>
}