package by.runets.vehiclescrapper.scrapper.copart.service.impl

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.BodyStyleType
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.BodyStyleTypeService
import by.runets.vehiclescrapper.scrapper.copart.provider.impl.BodyStyleTypeScrapper
import by.runets.vehiclescrapper.scrapper.copart.service.IScrapService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BodyStyleTypeScrapService(@Autowired private var bodyStyleTypeScrapper: BodyStyleTypeScrapper,
                                @Autowired private var bodyStyleTypeService: BodyStyleTypeService) : AbstractScrapService<Set<BodyStyleType>>(), IScrapService<Set<BodyStyleType>> {

    override suspend fun scrapAndSave(): Set<BodyStyleType> {
        val damageTypeDataSet = bodyStyleTypeScrapper.scrap()
        bodyStyleTypeService.saveAll(damageTypeDataSet!!)
        return damageTypeDataSet
    }
}