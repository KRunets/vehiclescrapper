package by.runets.carscrapper.db.service.lookup.vehicle

import by.runets.carscrapper.db.domain.lookup.vehicle.BodyStyleType
import by.runets.carscrapper.db.repository.lookup.vehicle.BodyStyleTypeRepository
import by.runets.carscrapper.db.service.AbstractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalOperator

@Service
class BodyStyleTypeService(@Autowired private var bodyStyleTypeRepository: BodyStyleTypeRepository, @Autowired private var transactionalOperator: TransactionalOperator
) : AbstractService<BodyStyleType>(repository = bodyStyleTypeRepository, transactionalOperator = transactionalOperator)