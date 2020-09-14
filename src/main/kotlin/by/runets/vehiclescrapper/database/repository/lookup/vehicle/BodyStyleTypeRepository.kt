package by.runets.vehiclescrapper.database.repository.lookup.vehicle

import by.runets.vehiclescrapper.database.domain.lookup.vehicle.BodyStyleType
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BodyStyleTypeRepository : ReactiveCrudRepository<BodyStyleType, UUID>