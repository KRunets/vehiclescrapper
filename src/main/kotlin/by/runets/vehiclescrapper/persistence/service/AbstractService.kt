package by.runets.vehiclescrapper.persistence.service

import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.reactive.awaitLast
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.transaction.reactive.TransactionalOperator
import reactor.core.publisher.Flux
import java.util.*

abstract class AbstractService<T>(
        private var repository: ReactiveCrudRepository<T, UUID>,
        private var transactionalOperator: TransactionalOperator)
    : IService<T, UUID> {

    @Autowired
    private lateinit var databaseClient: DatabaseClient

    override suspend fun save(entity: T): T? {
        return transactionalOperator.transactional(repository.save(entity)).awaitSingle()
    }

    override suspend fun saveAll(data: Iterable<T>) {
        transactionalOperator.transactional(repository.saveAll(data)).awaitLast()
    }

    override suspend fun findById(id: UUID): T? {
        return transactionalOperator.transactional(repository.findById(id)).awaitFirstOrNull()
    }

    override suspend fun findAll(): Flux<T> {
        return transactionalOperator.transactional(repository.findAll())
    }

    override suspend fun deleteById(id: UUID): Void? {
        return transactionalOperator.transactional(repository.deleteById(id)).awaitFirstOrNull()
    }
}