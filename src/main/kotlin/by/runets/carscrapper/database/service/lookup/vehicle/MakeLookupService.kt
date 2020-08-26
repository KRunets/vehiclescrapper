package by.runets.carscrapper.database.service.lookup.vehicle

import by.runets.carscrapper.database.domain.lookup.vehicle.MakeLookup
import by.runets.carscrapper.database.repository.lookup.vehicle.MakeLookupRepository
import by.runets.carscrapper.database.service.AbstractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalOperator

@Service
class MakeLookupService(@Autowired private var makeLookupRepository: MakeLookupRepository, @Autowired private var transactionalOperator: TransactionalOperator
) : AbstractService<MakeLookup>(repository = makeLookupRepository, transactionalOperator = transactionalOperator)