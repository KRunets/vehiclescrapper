package by.runets.vehiclescrapper.persistence.domain.lookup.vehicle

import lombok.Getter
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Getter
@Table("fuel_type")
class FuelType(type: String, makeLookupId: UUID) {
    @Id
    var id: UUID? = null
    var type: String? = type
    var makeLookupId: UUID? = makeLookupId

    override fun toString(): String {
        return "FuelType(id=$id, makeLookup=${makeLookupId}, type=$type)"
    }
}