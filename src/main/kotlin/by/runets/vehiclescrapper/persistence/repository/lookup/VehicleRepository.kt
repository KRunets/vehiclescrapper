package by.runets.vehiclescrapper.persistence.repository.lookup

import by.runets.vehiclescrapper.persistence.domain.Vehicle
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.util.*

@Repository
interface VehicleRepository : ReactiveCrudRepository<Vehicle, UUID> {

    @Query("SELECT * FROM vehicle where lot_number=$1")
    fun findVehicleByLotNumber(vin : String?) : Mono<Vehicle>

}