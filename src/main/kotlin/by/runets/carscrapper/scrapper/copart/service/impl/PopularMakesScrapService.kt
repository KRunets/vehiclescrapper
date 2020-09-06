package by.runets.carscrapper.scrapper.copart.service.impl

import by.runets.carscrapper.database.domain.lookup.vehicle.MakeLookup
import by.runets.carscrapper.database.service.lookup.vehicle.MakeLookupService
import by.runets.carscrapper.scrapper.copart.provider.impl.PopularMakesScrapper
import by.runets.carscrapper.scrapper.copart.service.IScrapService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PopularMakesScrapService(
        @Autowired private val makesScrapper: PopularMakesScrapper,
        @Autowired private val makeLookupService: MakeLookupService) : IScrapService<Set<MakeLookup>> {

    override suspend fun scrapAndSave(): Set<MakeLookup> {
        val dataSet = makesScrapper.scrap()
        makeLookupService.saveAll(dataSet)
        return dataSet
    }
}