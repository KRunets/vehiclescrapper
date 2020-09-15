package by.runets.vehiclescrapper.persistence.service.lookup.vehicle

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.EngineType
import by.runets.vehiclescrapper.persistence.repository.lookup.vehicle.EngineTypeRepository
import by.runets.vehiclescrapper.persistence.service.AbstractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalOperator

@Service
class EngineTypeTypeService(@Autowired
                            private var engineTypeRepository: EngineTypeRepository,
                            @Autowired
                            private var transactionalOperator: TransactionalOperator) :
        AbstractService<EngineType>(repository = engineTypeRepository, transactionalOperator = transactionalOperator)
