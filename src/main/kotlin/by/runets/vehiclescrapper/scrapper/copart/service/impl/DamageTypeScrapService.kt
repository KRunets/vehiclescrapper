package by.runets.vehiclescrapper.scrapper.copart.service.impl

import by.runets.vehiclescrapper.persistence.domain.lookup.DamageType
import by.runets.vehiclescrapper.persistence.service.lookup.DamageTypeService
import by.runets.vehiclescrapper.scrapper.copart.provider.impl.DamageTypeScrapper
import by.runets.vehiclescrapper.scrapper.copart.service.IScrapService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DamageTypeScrapService(@Autowired private var damageTypeScrapper: DamageTypeScrapper,
                             @Autowired private var damageTypeService: DamageTypeService) : AbstractScrapService<Set<DamageType>>() {

    override suspend fun scrapAndSave(): Set<DamageType> {
        val damageTypeDataSet = damageTypeScrapper.scrap()
        damageTypeService.saveAll(damageTypeDataSet!!)
        return damageTypeDataSet
    }
}