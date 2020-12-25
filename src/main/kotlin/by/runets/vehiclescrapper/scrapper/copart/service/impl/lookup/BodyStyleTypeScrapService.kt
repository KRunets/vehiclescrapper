package by.runets.vehiclescrapper.scrapper.copart.service.impl.lookup

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.BodyStyleType
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.BodyStyleTypeService
import by.runets.vehiclescrapper.scrapper.copart.executor.impl.lookup.BodyStyleTypeScrapperExecutor
import by.runets.vehiclescrapper.scrapper.copart.service.impl.AbstractScrapService
import by.runets.vehiclescrapper.utils.annotation.LogExecutionTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BodyStyleTypeScrapService(@Autowired private var bodyStyleTypeScrapper: BodyStyleTypeScrapperExecutor,
                                @Autowired private var bodyStyleTypeService: BodyStyleTypeService) : AbstractScrapService<Set<BodyStyleType>>() {
    @LogExecutionTime
    override suspend fun scrapAndSave(): Set<BodyStyleType> {
        val damageTypeDataSet = bodyStyleTypeScrapper.scrap()
        bodyStyleTypeService.saveAll(damageTypeDataSet!!)
        return damageTypeDataSet
    }
}