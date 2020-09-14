package by.runets.vehiclescrapper.database.service.lookup.vehicle

import by.runets.vehiclescrapper.database.domain.lookup.vehicle.BodyStyleType
import by.runets.vehiclescrapper.database.repository.lookup.vehicle.BodyStyleTypeRepository
import by.runets.vehiclescrapper.database.service.AbstractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalOperator

@Service
class BodyStyleTypeService(@Autowired private var bodyStyleTypeRepository: BodyStyleTypeRepository,
                           @Autowired private var transactionalOperator: TransactionalOperator
) : AbstractService<BodyStyleType>(
        repository = bodyStyleTypeRepository,
        transactionalOperator = transactionalOperator)