package by.runets.vehiclescrapper.scrapper.copart.service.impl.lookup

import by.runets.vehiclescrapper.configuration.properties.ScrapperProperties
import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.ModelLookup
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.MakeLookupService
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.ModelLookupService
import by.runets.vehiclescrapper.scrapper.copart.executor.impl.lookup.ModelLookupScrapperExecutor
import by.runets.vehiclescrapper.scrapper.copart.service.impl.AbstractScrapService
import by.runets.vehiclescrapper.utils.annotation.LogExecutionTime
import by.runets.vehiclescrapper.utils.coroutines.onError
import by.runets.vehiclescrapper.utils.coroutines.onNext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ModelLookupScrapService(@Autowired private val makeLookupService: MakeLookupService,
                              @Autowired private val modelLookupScrapper: ModelLookupScrapperExecutor,
                              @Autowired private val modelLookupService: ModelLookupService,
                              @Autowired private val scrapperProperties : ScrapperProperties) : AbstractScrapService<ModelLookup>() {

    @LogExecutionTime
    override suspend fun scrapAndSaveVoid() {
        val modelLookupDataSet = mutableSetOf<ModelLookup>()
        val searchCriteria = mutableMapOf<String, Any>()

        val makeLookupDataSet = makeLookupService.findMakeLookupSetByModelLookup()
        makeLookupDataSet
                .map { makeLookup: MakeLookup ->
                    run {
                        searchCriteria[MakeLookup::javaClass.name] = makeLookup
                        val data = modelLookupScrapper.scrapAll(searchCriteria)
                        println("Make : ${makeLookup.type}")
                        println("Model {\n" +
                                "Total count: : ${data.size}\n" +
                                "Data : $data \n" +
                                "}")
                        modelLookupDataSet.addAll(data)
                    }
                }
                .doOnError{error -> println("The error $error occurred") }
                .onError { modelLookupService.saveAll(modelLookupDataSet) }
                .onNext { modelLookupService.saveAll(modelLookupDataSet) }
                .retry(scrapperProperties.retryLimit)
                .subscribe()
    }

    @LogExecutionTime
    override suspend fun scrapAndSaveByMake(make: String) {
        val makeLookup = makeLookupService.findByType(make)
        val searchCriteria = mutableMapOf<String, Any>()
        searchCriteria[MakeLookup::javaClass.name] = makeLookup
        val data = modelLookupScrapper.scrapAll(searchCriteria)
        modelLookupService.saveAll(data)
    }
}

