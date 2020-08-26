package by.runets.carscrapper.database.repository.lookup

import by.runets.carscrapper.database.domain.lookup.DamageType
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DamageTypeRepository : ReactiveCrudRepository<DamageType, UUID>