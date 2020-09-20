package by.runets.vehiclescrapper.scrapper.copart.provider

interface IScrapper<T, C> {
    suspend fun scrap(): T?

    fun scrapByCriteria(criteria: C): Set<T>
}