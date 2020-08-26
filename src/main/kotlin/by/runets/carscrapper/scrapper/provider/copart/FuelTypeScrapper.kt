package by.runets.carscrapper.scrapper.provider.copart

import by.runets.carscrapper.database.domain.lookup.vehicle.FuelType
import by.runets.carscrapper.scrapper.provider.IScrapper
import org.springframework.stereotype.Service

@Service
class FuelTypeScrapper : IScrapper<FuelType> {


    override fun scrap(url: String): Set<FuelType> {


        return mutableSetOf()
    }
}
