package by.runets.vehiclescrapper.scrapper.copart.service.scrapper.impl.lookup

import by.runets.vehiclescrapper.configuration.properties.ScrapperProperties
import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.EngineType
import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.EngineTypeTypeService
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.MakeLookupService
import by.runets.vehiclescrapper.scrapper.copart.processor.impl.lookup.EngineTypeScrapperProcessor
import by.runets.vehiclescrapper.scrapper.copart.service.scrapper.impl.AbstractScrapService
import by.runets.vehiclescrapper.utils.annotation.LogExecutionTime
import by.runets.vehiclescrapper.utils.coroutines.onError
import by.runets.vehiclescrapper.utils.coroutines.onNext
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EngineTypeScrapService(@Autowired private val makeLookupService: MakeLookupService,
                             @Autowired private val engineTypeService: EngineTypeTypeService,
                             @Autowired private val scrapperProperties: ScrapperProperties,
                             @Autowired private val engineTypeScrapper: EngineTypeScrapperProcessor) : AbstractScrapService<EngineType>() {

    private val logger = LoggerFactory.getLogger(javaClass)

    @LogExecutionTime
    override suspend fun scrapAndSaveVoid() {
        val engineTypeDataSet = mutableSetOf<EngineType>()

        val makeLookupDataSet = makeLookupService.findMakeLookupSetByEngineType()
        val searchCriteria = mutableMapOf<String, Any>()

        makeLookupDataSet
                .map { makeLookup: MakeLookup ->
                    run {
                        searchCriteria[MakeLookup::javaClass.name] = makeLookup
                        val data = engineTypeScrapper.scrapAll(searchCriteria)
                        engineTypeDataSet.addAll(data)
                    }
                }
                .doOnError { error -> logger.error(error.toString()) }
                .onError {engineTypeService.saveAll(engineTypeDataSet)}
                .onNext { engineTypeService.saveAll(engineTypeDataSet) }
                .retry(scrapperProperties.retryLimit)
                .subscribe()
    }

    @LogExecutionTime
    override suspend fun scrapAndSaveByMake(make: String) {
        val makeLookup = makeLookupService.findByType(make)
        val searchCriteria = mutableMapOf<String, Any>()

        searchCriteria[MakeLookup::javaClass.name] = makeLookup
        val data = engineTypeScrapper.scrapAll(searchCriteria)
        engineTypeService.saveAll(data)
    }
}

