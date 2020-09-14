package by.runets.vehiclescrapper.database.service.lookup.vehicle

import by.runets.vehiclescrapper.database.domain.lookup.vehicle.ModelLookup
import by.runets.vehiclescrapper.database.repository.lookup.vehicle.ModelLookupRepository
import by.runets.vehiclescrapper.database.service.AbstractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalOperator

@Service
class ModelLookupService(@Autowired private var modelLookupRepository: ModelLookupRepository,
                         @Autowired private var transactionalOperator: TransactionalOperator
) : AbstractService<ModelLookup>(
        repository = modelLookupRepository,
        transactionalOperator = transactionalOperator)