package by.runets.vehiclescrapper.persistence.service.lookup

import by.runets.vehiclescrapper.persistence.domain.lookup.DamageType
import by.runets.vehiclescrapper.persistence.repository.lookup.DamageTypeRepository
import by.runets.vehiclescrapper.persistence.service.AbstractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalOperator

@Service
class DamageTypeService(@Autowired private var damageTypeRepository: DamageTypeRepository,
                        @Autowired private var transactionalOperator: TransactionalOperator
) : AbstractService<DamageType>(repository = damageTypeRepository,
        transactionalOperator = transactionalOperator)