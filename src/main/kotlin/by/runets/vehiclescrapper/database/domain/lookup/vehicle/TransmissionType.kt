package by.runets.vehiclescrapper.database.domain.lookup.vehicle

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("transmission_type")
class TransmissionType {

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
        return "TransmissionType(id=$id, type=$type)"
    }
}