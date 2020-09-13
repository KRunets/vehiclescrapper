package by.runets.carscrapper.database.repository.lookup.vehicle

import by.runets.carscrapper.database.domain.lookup.vehicle.MakeLookup
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import java.util.*

@Repository
interface MakeLookupRepository : ReactiveCrudRepository<MakeLookup, UUID> {
    @Query("SELECT * FROM make_lookup WHERE type = $1")
    fun findByType(type: String) : Flux<MakeLookup>
}