package by.runets.carscrapper.db.repository.lookup

import by.runets.carscrapper.db.domain.lookup.DamageType
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DamageTypeRepository : ReactiveCrudRepository<DamageType, UUID>