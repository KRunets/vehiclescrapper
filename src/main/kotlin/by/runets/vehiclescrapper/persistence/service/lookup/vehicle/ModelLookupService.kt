package by.runets.vehiclescrapper.persistence.service.lookup.vehicle

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.ModelLookup
import by.runets.vehiclescrapper.persistence.repository.lookup.vehicle.ModelLookupRepository
import by.runets.vehiclescrapper.persistence.service.AbstractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalOperator

@Service
class ModelLookupService(@Autowired private var modelLookupRepository: ModelLookupRepository,
                         @Autowired private var transactionalOperator: TransactionalOperator
) : AbstractService<ModelLookup>(
        repository = modelLookupRepository,
        transactionalOperator = transactionalOperator)