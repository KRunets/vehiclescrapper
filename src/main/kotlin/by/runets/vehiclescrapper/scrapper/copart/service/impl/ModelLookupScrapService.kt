package by.runets.vehiclescrapper.scrapper.copart.service.impl

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.ModelLookup
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.MakeLookupService
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.ModelLookupService
import by.runets.vehiclescrapper.scrapper.copart.provider.impl.ModelLookupScrapper
import by.runets.vehiclescrapper.utils.annotation.LogExecutionTime
import by.runets.vehiclescrapper.utils.coroutines.onNext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ModelLookupScrapService(@Autowired private val makeLookupService: MakeLookupService,
                              @Autowired private val modelLookupScrapper: ModelLookupScrapper,
                              @Autowired private val modelLookupService: ModelLookupService) : AbstractScrapService<ModelLookup>() {

    @LogExecutionTime
    override suspend fun scrapAndSaveVoid() {
        val modelLookupDataSet = mutableSetOf<ModelLookup>()
        val makeLookupDataSet = makeLookupService.findMakeLookupSetByModelLookup()
        makeLookupDataSet
                .map { makeLookup: MakeLookup ->
                    run {
                        val data = modelLookupScrapper.scrapByCriteria(makeLookup)
                        println("Make : ${makeLookup.type}")
                        println("Model {\n" +
                                "Total count: : ${data.size}\n" +
                                "Data : $data \n" +
                                "}")
                        modelLookupDataSet.addAll(data)
                    }
                }.onNext { modelLookupService.saveAll(modelLookupDataSet) }
                .subscribe()
    }

    @LogExecutionTime
    override suspend fun scrapAndSaveByMake(make: String) {
        val makeLookup = makeLookupService.findByType(make)
        val data = modelLookupScrapper.scrapByCriteria(makeLookup)
        modelLookupService.saveAll(data)
    }
}

