package by.runets.vehiclescrapper.scrapper.copart.service.impl

import by.runets.vehiclescrapper.database.domain.lookup.vehicle.TransmissionType
import by.runets.vehiclescrapper.database.service.lookup.vehicle.TransmissionTypeService
import by.runets.vehiclescrapper.scrapper.copart.provider.impl.TransmissionTypeScrapper
import by.runets.vehiclescrapper.scrapper.copart.service.IScrapService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransmissionTypeScrapService(@Autowired private var transmissionTypeService: TransmissionTypeService,
                                   @Autowired private var transmissionTypeScrapper: TransmissionTypeScrapper) : AbstractScrapService<Set<TransmissionType>>(), IScrapService<Set<TransmissionType>> {

    override suspend fun scrapAndSave(): Set<TransmissionType> {
        val transmissionTypeSet = transmissionTypeScrapper.scrap()
        transmissionTypeService.saveAll(transmissionTypeSet!!)
        return transmissionTypeSet
    }
}