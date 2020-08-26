package by.runets.carscrapper.database.repository.lookup.vehicle

import by.runets.carscrapper.database.domain.lookup.vehicle.FuelType
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FuelTypeRepository : ReactiveCrudRepository<FuelType, UUID>