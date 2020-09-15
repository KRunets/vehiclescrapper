package by.runets.vehiclescrapper.persistence.service

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import reactor.core.publisher.Flux

interface IMakeLookupService {
    suspend fun findByType(type: String): MakeLookup

    suspend fun findActualMakeLookups(): Flux<MakeLookup>
}