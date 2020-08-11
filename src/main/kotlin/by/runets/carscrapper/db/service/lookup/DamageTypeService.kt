package by.runets.carscrapper.db.service.lookup

import by.runets.carscrapper.db.domain.lookup.DamageType
import by.runets.carscrapper.db.repository.lookup.DamageTypeRepository
import by.runets.carscrapper.db.service.AbstractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalOperator

@Service
class DamageTypeService(@Autowired private var damageTypeRepository: DamageTypeRepository, @Autowired private var transactionalOperator: TransactionalOperator
) : AbstractService<DamageType>(repository = damageTypeRepository, transactionalOperator = transactionalOperator)