package by.runets.vehiclescrapper.persistence.service.lookup.vehicle

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.VehicleType
import by.runets.vehiclescrapper.persistence.repository.lookup.vehicle.VehicleTypeRepository
import by.runets.vehiclescrapper.persistence.service.AbstractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalOperator

@Service
class VehicleTypeTypeService(@Autowired private var vehicleTypeRepository: VehicleTypeRepository,
                             @Autowired private var transactionalOperator: TransactionalOperator)
    : AbstractService<VehicleType>(repository = vehicleTypeRepository,
        transactionalOperator = transactionalOperator)
