package by.runets.vehiclescrapper.scrapper.copart.service.impl

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.ModelLookup
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.MakeLookupService
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.ModelLookupService
import by.runets.vehiclescrapper.scrapper.copart.provider.impl.ModelLookupScrapper
import by.runets.vehiclescrapper.utils.annotation.LogExecutionTime
import by.runets.vehiclescrapper.utils.coroutines.onNext
import org.openqa.selenium.StaleElementReferenceException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.util.retry.Retry

@Service
class ModelLookupScrapService(@Autowired private val makeLookupService: MakeLookupService,
                              @Autowired private val modelLookupScrapper: ModelLookupScrapper,
                              @Autowired private val modelLookupService: ModelLookupService) : AbstractScrapService<ModelLookup>() {

    @LogExecutionTime
    override suspend fun scrapAndSaveVoid() {
        val modelLookupDataSet = mutableSetOf<ModelLookup>()
        val searchCriteria = mutableMapOf<String, Any>()

        val makeLookupDataSet = makeLookupService.findMakeLookupSetByModelLookup()
        makeLookupDataSet
                .map { makeLookup: MakeLookup ->
                    run {
                        searchCriteria[MakeLookup::javaClass.name] = makeLookup
                        val data = modelLookupScrapper.scrapByCriteria(searchCriteria)
                        println("Make : ${makeLookup.type}")
                        println("Model {\n" +
                                "Total count: : ${data.size}\n" +
                                "Data : $data \n" +
                                "}")
                        modelLookupDataSet.addAll(data)
                    }
                }
                .doOnError{error -> println("Error $error")}
                .onNext { modelLookupService.saveAll(modelLookupDataSet) }
                .retry(2)
                .subscribe()
    }

    @LogExecutionTime
    override suspend fun scrapAndSaveByMake(make: String) {
        val makeLookup = makeLookupService.findByType(make)
        val searchCriteria = mutableMapOf<String, Any>()
        searchCriteria[MakeLookup::javaClass.name] = makeLookup
        val data = modelLookupScrapper.scrapByCriteria(searchCriteria)
        modelLookupService.saveAll(data)
    }
}

