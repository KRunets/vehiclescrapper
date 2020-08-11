package by.runets.carscrapper.db.service.lookup.vehicle

import by.runets.carscrapper.db.domain.lookup.vehicle.MakeLookup
import by.runets.carscrapper.db.repository.lookup.vehicle.MakeLookupRepository
import by.runets.carscrapper.db.service.AbstractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalOperator

@Service
class MakeLookupService(@Autowired private var makeLookupRepository: MakeLookupRepository, @Autowired private var transactionalOperator: TransactionalOperator
) : AbstractService<MakeLookup>(repository = makeLookupRepository, transactionalOperator = transactionalOperator)