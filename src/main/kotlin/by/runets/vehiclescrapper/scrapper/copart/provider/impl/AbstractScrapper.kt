package by.runets.vehiclescrapper.scrapper.copart.provider.impl

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.scrapper.copart.provider.IScrapper

abstract class AbstractScrapper<T> : IScrapper<T> {
    override suspend fun scrap(): T? {
        TODO("not implemented")
    }

    override fun scrapByMakeLookup(makeLookup: MakeLookup): Set<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}