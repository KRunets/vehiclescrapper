package by.runets.vehiclescrapper.database.service.lookup

import by.runets.vehiclescrapper.database.domain.lookup.DamageType
import by.runets.vehiclescrapper.database.repository.lookup.DamageTypeRepository
import by.runets.vehiclescrapper.database.service.AbstractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalOperator

@Service
class DamageTypeService(@Autowired private var damageTypeRepository: DamageTypeRepository,
                        @Autowired private var transactionalOperator: TransactionalOperator
) : AbstractService<DamageType>(repository = damageTypeRepository,
        transactionalOperator = transactionalOperator)