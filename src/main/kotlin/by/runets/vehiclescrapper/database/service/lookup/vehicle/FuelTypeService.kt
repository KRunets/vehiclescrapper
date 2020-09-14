package by.runets.vehiclescrapper.database.service.lookup.vehicle

import by.runets.vehiclescrapper.database.domain.lookup.vehicle.FuelType
import by.runets.vehiclescrapper.database.repository.lookup.vehicle.FuelTypeRepository
import by.runets.vehiclescrapper.database.service.AbstractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalOperator

@Service
class FuelTypeService(
        @Autowired
        private var fuelTypeRepository: FuelTypeRepository,
        @Autowired
        private var transactionalOperator: TransactionalOperator
) : AbstractService<FuelType>(repository = fuelTypeRepository, transactionalOperator = transactionalOperator)