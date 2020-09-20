package by.runets.vehiclescrapper.persistence.repository.lookup.vehicle

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.ModelLookup
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import java.util.*

@Repository
interface ModelLookupRepository : ReactiveCrudRepository<ModelLookup, UUID> {
    @Query("SELECT * FROM model_lookup AS mdl JOIN make_lookup AS mkl ON mdl.make = mkl.id WHERE mkl.type = $1")
    fun findModelLookupByMake(make: String) : Flux<ModelLookup>
}