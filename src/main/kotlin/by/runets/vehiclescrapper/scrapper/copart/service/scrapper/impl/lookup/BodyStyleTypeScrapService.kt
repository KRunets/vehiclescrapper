package by.runets.vehiclescrapper.scrapper.copart.service.scrapper.impl.lookup

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.BodyStyleType
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.BodyStyleTypeService
import by.runets.vehiclescrapper.scrapper.copart.processor.impl.lookup.BodyStyleTypeScrapperProcessor
import by.runets.vehiclescrapper.scrapper.copart.service.scrapper.impl.AbstractScrapService
import by.runets.vehiclescrapper.utils.annotation.LogExecutionTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BodyStyleTypeScrapService(@Autowired private var bodyStyleTypeScrapper: BodyStyleTypeScrapperProcessor,
                                @Autowired private var bodyStyleTypeService: BodyStyleTypeService) : AbstractScrapService<Set<BodyStyleType>>() {
    @LogExecutionTime
    override suspend fun scrapAndSave(): Set<BodyStyleType> {
        val damageTypeDataSet = bodyStyleTypeScrapper.scrap()
        bodyStyleTypeService.saveAll(damageTypeDataSet!!)
        return damageTypeDataSet
    }
}