package by.runets.carscrapper.db.service

interface IService<T, ID> {

    suspend fun save(entity: T): T?

    suspend fun findById(id: ID): T?

    suspend fun findAll(): T?

    suspend fun deleteById(id: ID): Void?
}