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

    @Query("SELECT *\n" +
            "FROM make_lookup\n" +
            "WHERE TYPE NOT IN (SELECT distinct m.type\n" +
            "                   FROM make_lookup AS m\n" +
            "                            INNER JOIN engine_type AS e ON e.make_lookup_id = m.id)")
    fun findActualMakeLookups() : Flux<MakeLookup>
}