package by.runets.carscrapper.database.service.lookup.vehicle

import by.runets.carscrapper.database.domain.lookup.vehicle.VehicleType
import by.runets.carscrapper.database.repository.lookup.vehicle.VehicleTypeRepository
import by.runets.carscrapper.database.service.AbstractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalOperator

@Service
class VehicleTypeTypeService(@Autowired private var vehicleTypeRepository: VehicleTypeRepository,
                             @Autowired private var transactionalOperator: TransactionalOperator)
    : AbstractService<VehicleType>(repository = vehicleTypeRepository,
        transactionalOperator = transactionalOperator)
