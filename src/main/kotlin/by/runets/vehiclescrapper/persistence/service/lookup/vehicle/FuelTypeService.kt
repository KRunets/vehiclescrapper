package by.runets.vehiclescrapper.persistence.service.lookup.vehicle

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.FuelType
import by.runets.vehiclescrapper.persistence.repository.lookup.vehicle.FuelTypeRepository
import by.runets.vehiclescrapper.persistence.service.AbstractService
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