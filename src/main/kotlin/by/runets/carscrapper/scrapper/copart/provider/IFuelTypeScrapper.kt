package by.runets.carscrapper.scrapper.copart.provider

import by.runets.carscrapper.database.domain.lookup.vehicle.FuelType
import by.runets.carscrapper.database.domain.lookup.vehicle.MakeLookup

interface IFuelTypeScrapper : IScrapper<FuelType> {
    fun scrap(makeLookup: MakeLookup): Set<FuelType>
}