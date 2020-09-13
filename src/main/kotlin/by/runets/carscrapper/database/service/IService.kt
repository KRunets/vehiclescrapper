package by.runets.carscrapper.database.service

import reactor.core.publisher.Flux

interface IService<T, ID> {

    suspend fun save(entity: T): T?

    suspend fun saveAll(data: Iterable<T>)

    suspend fun findById(id: ID): T?

    suspend fun findAllFlux(): Flux<T>

    suspend fun findAll(): Set<T>

    suspend fun deleteById(id: ID): Void?
}