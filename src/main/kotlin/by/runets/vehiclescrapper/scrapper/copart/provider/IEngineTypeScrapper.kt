package by.runets.vehiclescrapper.scrapper.copart.provider

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.EngineType
import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup

interface IEngineTypeScrapper : IScrapper<EngineType> {
    fun scrap(makeLookup: MakeLookup): Set<EngineType>
}