package by.runets.vehiclescrapper.scrapper.copart.provider

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.FuelType
import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup

interface IFuelTypeScrapper : IScrapper<FuelType> {
    fun scrap(makeLookup: MakeLookup): Set<FuelType>
}