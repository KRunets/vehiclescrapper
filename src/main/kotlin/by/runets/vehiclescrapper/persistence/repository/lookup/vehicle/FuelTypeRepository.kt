package by.runets.vehiclescrapper.persistence.repository.lookup.vehicle

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.FuelType
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FuelTypeRepository : ReactiveCrudRepository<FuelType, UUID>