package by.runets.carscrapper.db.repository.lookup.vehicle

import by.runets.carscrapper.db.domain.lookup.vehicle.VehicleType
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface VehicleTypeRepository : ReactiveCrudRepository<VehicleType, UUID>