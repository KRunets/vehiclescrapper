package by.runets.vehiclescrapper.scrapper.copart.service.impl.lookup

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.TransmissionType
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.TransmissionTypeService
import by.runets.vehiclescrapper.scrapper.copart.processor.impl.lookup.TransmissionTypeScrapperProcessor
import by.runets.vehiclescrapper.scrapper.copart.service.impl.AbstractScrapService
import by.runets.vehiclescrapper.utils.annotation.LogExecutionTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransmissionTypeScrapService(@Autowired
                                   private var transmissionTypeService: TransmissionTypeService,
                                   @Autowired
                                   private var transmissionTypeScrapper: TransmissionTypeScrapperProcessor) : AbstractScrapService<Set<TransmissionType>>() {

    @LogExecutionTime
    override suspend fun scrapAndSave(): Set<TransmissionType> {
        val transmissionTypeSet = transmissionTypeScrapper.scrap()
        transmissionTypeService.saveAll(transmissionTypeSet!!)
        return transmissionTypeSet
    }
}