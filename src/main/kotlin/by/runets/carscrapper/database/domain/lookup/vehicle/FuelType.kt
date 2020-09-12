package by.runets.carscrapper.database.domain.lookup.vehicle

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("fuel_type")
class FuelType(type: String, makeLookup: MakeLookup) {
    @Id
    private var id: UUID? = null
    private var makeLookup: MakeLookup? = makeLookup
    private var type: String? = type


    override fun toString(): String {
        return "FuelType(id=$id, makeLookup=${makeLookup?.type}, type=$type)"
    }

}