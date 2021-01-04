package by.runets.vehiclescrapper.persistence.service.lookup

import by.runets.vehiclescrapper.persistence.domain.Vehicle
import by.runets.vehiclescrapper.persistence.repository.lookup.VehicleRepository
import by.runets.vehiclescrapper.persistence.service.AbstractService
import by.runets.vehiclescrapper.persistence.service.IVehicleService
import kotlinx.coroutines.reactive.awaitFirst
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalOperator
import reactor.core.publisher.Mono


@Service
class VehicleService(@Autowired private var vehicleRepository: VehicleRepository,
                     @Autowired private var transactionalOperator: TransactionalOperator)
    : AbstractService<Vehicle>(repository = vehicleRepository, transactionalOperator = transactionalOperator), IVehicleService {

    override suspend fun findVehicleByLotNumber(lotNumber: String?): Mono<Vehicle> {
        return transactionalOperator.transactional(vehicleRepository.findVehicleByLotNumber(lotNumber))
    }

    override suspend fun updateVehicleDynamicDetails(entity: Vehicle): Vehicle? {
        val vehicle = findVehicleByLotNumber(entity.lotNumber).awaitFirst()
        if (vehicle != null) {
            vehicle.lotSold = entity.lotSold
            vehicle.currentBid = entity.currentBid
            vehicle.startingBid = entity.startingBid
            vehicle.location = entity.location
            vehicle.odometer = entity.odometer
            vehicle.saleDate = entity.saleDate
            vehicle.saleStatus = entity.saleStatus
            vehicle.estimatedRetailValue = entity.estimatedRetailValue
        }
        return super.save(vehicle)

    }
}