package by.runets.carscrapper.db.service

import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.transaction.reactive.TransactionalOperator
import java.util.*

abstract class AbstractService<T>(private var repository: ReactiveCrudRepository<T, UUID>, private var transactionalOperator: TransactionalOperator) : IService<T, UUID> {

    override suspend fun save(entity: T): T? {
        return transactionalOperator.transactional(repository.save(entity)).awaitSingle()
    }

    override suspend fun findById(id: UUID): T? {
        return transactionalOperator.transactional(repository.findById(id)).awaitFirstOrNull()
    }

    override suspend fun findAll(): T? {
        return transactionalOperator.transactional(repository.findAll()).awaitFirstOrNull()
    }

    override suspend fun deleteById(id: UUID): Void? {
        return transactionalOperator.transactional(repository.deleteById(id)).awaitFirstOrNull()
    }
}