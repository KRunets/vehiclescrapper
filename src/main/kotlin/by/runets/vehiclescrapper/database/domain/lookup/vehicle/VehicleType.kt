package by.runets.vehiclescrapper.database.domain.lookup.vehicle

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("vehicle_type")
class VehicleType {

    @Id
    var id: UUID? = null
    var type: String? = ""

    constructor()
    constructor(type: String?) {
        this.type = type
    }
    constructor(id: UUID?, type: String?) {
        this.id = id
        this.type = type
    }

    override fun toString(): String {
        return "VehicleType(id=$id, type=$type)"
    }

}