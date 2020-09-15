package by.runets.vehiclescrapper.persistence.service.lookup.vehicle

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.persistence.repository.lookup.vehicle.MakeLookupRepository
import by.runets.vehiclescrapper.persistence.service.AbstractService
import by.runets.vehiclescrapper.persistence.service.IMakeLookupService
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