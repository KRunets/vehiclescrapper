package by.runets.vehiclescrapper.database.service.lookup.vehicle

import by.runets.vehiclescrapper.database.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.database.repository.lookup.vehicle.MakeLookupRepository
import by.runets.vehiclescrapper.database.service.AbstractService
import by.runets.vehiclescrapper.database.service.IMakeLookupService
import kotlinx.coroutines.reactive.awaitFirst
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalOperator

@Service
class MakeLookupService(@Autowired private var makeLookupRepository: MakeLookupRepository,
                        @Autowired private var transactionalOperator: TransactionalOperator)
    : AbstractService<MakeLookup>(
        repository = makeLookupRepository,
        transactionalOperator = transactionalOperator), IMakeLookupService {

    override suspend fun findByType(type: String): MakeLookup {
        return transactionalOperator.transactional(makeLookupRepository.findByType(type)).awaitFirst()
    }
}