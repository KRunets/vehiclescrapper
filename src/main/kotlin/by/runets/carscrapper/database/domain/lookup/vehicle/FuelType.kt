package by.runets.carscrapper.database.domain.lookup.vehicle

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("fuel_type")
class FuelType(type: String) {
    @Id
    var id: UUID? = null
    var type: String? = type
}