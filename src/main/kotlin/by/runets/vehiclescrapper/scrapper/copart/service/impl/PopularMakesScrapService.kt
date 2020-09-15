package by.runets.vehiclescrapper.scrapper.copart.service.impl

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.MakeLookupService
import by.runets.vehiclescrapper.scrapper.copart.provider.impl.PopularMakesScrapper
import by.runets.vehiclescrapper.scrapper.copart.service.IScrapService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PopularMakesScrapService(
        @Autowired private val makesScrapper: PopularMakesScrapper,
        @Autowired private val makeLookupService: MakeLookupService) : AbstractScrapService<Set<MakeLookup>>(), IScrapService<Set<MakeLookup>> {

    override suspend fun scrapAndSave(): Set<MakeLookup> {
        val dataSet = makesScrapper.scrap()
        makeLookupService.saveAll(dataSet)
        return dataSet
    }
}