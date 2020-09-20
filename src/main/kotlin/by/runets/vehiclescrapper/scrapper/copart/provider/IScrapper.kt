package by.runets.vehiclescrapper.scrapper.copart.provider

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup

interface IScrapper<T> {
    suspend fun scrap(): T?

    fun scrapByMakeLookup(makeLookup: MakeLookup): Set<T>
}