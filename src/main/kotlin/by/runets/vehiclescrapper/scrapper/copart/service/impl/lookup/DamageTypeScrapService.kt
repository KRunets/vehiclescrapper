package by.runets.vehiclescrapper.scrapper.copart.service.impl.lookup

import by.runets.vehiclescrapper.persistence.domain.lookup.DamageType
import by.runets.vehiclescrapper.persistence.service.lookup.DamageTypeService
import by.runets.vehiclescrapper.scrapper.copart.executor.impl.lookup.DamageTypeScrapperExecutor
import by.runets.vehiclescrapper.scrapper.copart.service.impl.AbstractScrapService
import by.runets.vehiclescrapper.utils.annotation.LogExecutionTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DamageTypeScrapService(@Autowired private var damageTypeScrapper: DamageTypeScrapperExecutor,
                             @Autowired private var damageTypeService: DamageTypeService) : AbstractScrapService<Set<DamageType>>() {
    @LogExecutionTime
    override suspend fun scrapAndSave(): Set<DamageType> {
        val damageTypeDataSet = damageTypeScrapper.scrap()
        damageTypeService.saveAll(damageTypeDataSet!!)
        return damageTypeDataSet
    }
}