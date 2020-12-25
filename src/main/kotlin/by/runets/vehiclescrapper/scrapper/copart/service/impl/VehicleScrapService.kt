package by.runets.vehiclescrapper.scrapper.copart.service.impl

import by.runets.vehiclescrapper.persistence.domain.Vehicle
import by.runets.vehiclescrapper.persistence.service.lookup.VehicleService
import by.runets.vehiclescrapper.scrapper.copart.executor.impl.VehicleScrapperExecutor
import by.runets.vehiclescrapper.utils.annotation.LogExecutionTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VehicleScrapService(@Autowired private var vehicleService: VehicleService,
                          @Autowired private var vehicleScrapperProcessor: VehicleScrapperExecutor) : AbstractScrapService<Set<Vehicle>>() {
    @LogExecutionTime
    override suspend fun scrapAndSaveByCriteria(searchCriteria: Map<String, Any>) {
        val vehicles = vehicleScrapperProcessor.scrapAll(searchCriteria)
        vehicleService.saveAll(vehicles)
    }
}