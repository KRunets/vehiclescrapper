package by.runets.vehiclescrapper.persistence.service

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.ModelLookup
import reactor.core.publisher.Flux


interface IModelLookupService {
    suspend fun findByMake(make: String): Flux<ModelLookup>
}