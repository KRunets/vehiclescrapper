package by.runets.vehiclescrapper.scrapper.copart.service.scrapper.impl.lookup

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.MakeLookupService
import by.runets.vehiclescrapper.scrapper.copart.processor.impl.lookup.PopularMakesScrapperProcessor
import by.runets.vehiclescrapper.scrapper.copart.service.scrapper.impl.AbstractScrapService
import by.runets.vehiclescrapper.utils.annotation.LogExecutionTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PopularMakesScrapService(@Autowired private val makesScrapper: PopularMakesScrapperProcessor,
                               @Autowired private val makeLookupService: MakeLookupService) :
        AbstractScrapService<Set<MakeLookup>>() {

    @LogExecutionTime
    override suspend fun scrapAndSave(): Set<MakeLookup> {
        val dataSet = makesScrapper.scrap()
        makeLookupService.saveAll(dataSet)
        return dataSet
    }
}