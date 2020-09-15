package by.runets.vehiclescrapper.scrapper.copart.service.impl

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.EngineType
import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.EngineTypeTypeService
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.MakeLookupService
import by.runets.vehiclescrapper.scrapper.copart.provider.impl.EngineTypeScrapper
import by.runets.vehiclescrapper.scrapper.copart.service.IEngineTypeScrapService
import by.runets.vehiclescrapper.utils.coroutines.onNext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EngineTypeScrapService(@Autowired private val makeLookupService: MakeLookupService,
                             @Autowired private val engineTypeService: EngineTypeTypeService,
                             @Autowired private val engineTypeScrapper: EngineTypeScrapper) : IEngineTypeScrapService {

    override suspend fun scrapAndSave() {
        val engineTypeDataSet = mutableSetOf<EngineType>()

        val makeLookupDataSet = makeLookupService.findAll()
        makeLookupDataSet.map { makeLookup: MakeLookup ->
            run {
                val data = engineTypeScrapper.scrap(makeLookup)
                println("Parsed data $data")
                engineTypeDataSet.addAll(data)
            }
        }.onNext { engineTypeService.saveAll(engineTypeDataSet) }.subscribe()
    }

    override suspend fun scrapAndSaveByMake(make: String) {
        val makeLookup = makeLookupService.findByType(make)
        val data = engineTypeScrapper.scrap(makeLookup)
        println("Parsed data $data")
        engineTypeService.saveAll(data)
    }
}

