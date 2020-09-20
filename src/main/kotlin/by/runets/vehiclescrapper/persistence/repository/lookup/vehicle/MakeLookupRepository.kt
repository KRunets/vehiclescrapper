package by.runets.vehiclescrapper.persistence.repository.lookup.vehicle

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import java.util.*

@Repository
interface MakeLookupRepository : ReactiveCrudRepository<MakeLookup, UUID> {
    @Query("SELECT * FROM make_lookup WHERE type = $1")
    fun findByType(type: String): Flux<MakeLookup>

    @Query("SELECT * FROM make_lookup WHERE id NOT IN (SELECT DISTINCT make_lookup_id FROM fuel_type)")
    fun findMakeLookupSetByFuelType() : Flux<MakeLookup>

    @Query("SELECT * FROM make_lookup WHERE id NOT IN (SELECT DISTINCT make_lookup_id FROM engine_type)")
    fun findMakeLookupSetByEngineType() : Flux<MakeLookup>

    @Query("SELECT * FROM make_lookup WHERE id NOT IN (SELECT DISTINCT make FROM model_lookup)")
    fun findMakeLookupSetByModelLookup() : Flux<MakeLookup>
}