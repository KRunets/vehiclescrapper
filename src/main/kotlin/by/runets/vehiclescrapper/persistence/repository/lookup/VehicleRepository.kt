package by.runets.vehiclescrapper.persistence.repository.lookup

import by.runets.vehiclescrapper.persistence.domain.Vehicle
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface VehicleRepository : ReactiveCrudRepository<Vehicle, UUID>