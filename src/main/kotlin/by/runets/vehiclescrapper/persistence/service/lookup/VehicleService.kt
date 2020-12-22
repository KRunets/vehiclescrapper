package by.runets.vehiclescrapper.persistence.service.lookup

import by.runets.vehiclescrapper.persistence.domain.Vehicle
import by.runets.vehiclescrapper.persistence.repository.lookup.VehicleRepository
import by.runets.vehiclescrapper.persistence.service.AbstractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalOperator


@Service
class VehicleService(@Autowired private var vehicleRepository: VehicleRepository,
                     @Autowired private var transactionalOperator: TransactionalOperator)
    : AbstractService<Vehicle>(repository = vehicleRepository, transactionalOperator = transactionalOperator)