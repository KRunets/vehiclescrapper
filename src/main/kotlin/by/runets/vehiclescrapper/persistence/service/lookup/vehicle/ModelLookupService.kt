package by.runets.vehiclescrapper.persistence.service.lookup.vehicle

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.ModelLookup
import by.runets.vehiclescrapper.persistence.repository.lookup.vehicle.ModelLookupRepository
import by.runets.vehiclescrapper.persistence.service.AbstractService
import by.runets.vehiclescrapper.persistence.service.IModelLookupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalOperator
import reactor.core.publisher.Flux

@Service
class ModelLookupService(@Autowired private var modelLookupRepository: ModelLookupRepository,
                         @Autowired private var transactionalOperator: TransactionalOperator)
    : AbstractService<ModelLookup>(repository = modelLookupRepository, transactionalOperator = transactionalOperator), IModelLookupService {

    override suspend fun findByMake(make: String) : Flux<ModelLookup> {
        return transactionalOperator.transactional(modelLookupRepository.findModelLookupByMake(make))
    }
}