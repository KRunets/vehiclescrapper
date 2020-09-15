package by.runets.vehiclescrapper.persistence.domain.lookup.vehicle

import lombok.Getter
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Getter
@Table("fuel_type")
class FuelType(type: String, makeLookupUUID: UUID) {
    @Id
    private var id: UUID? = null
    private var type: String? = type
    private var makeLookupId: UUID? = makeLookupUUID

    fun setId(id: UUID) {
        this.id = id
    }

    fun getId(): UUID? {
        return id
    }

    fun setType(type: String) {
        this.type = type
    }

    fun getType(): String? {
        return type
    }

    fun setMakeLookupId(id: UUID) {
        this.makeLookupId = id
    }

    fun getMakeLookupId(): UUID? {
        return makeLookupId
    }

    override fun toString(): String {
        return "FuelType(id=$id, makeLookup=${makeLookupId}, type=$type)"
    }
}