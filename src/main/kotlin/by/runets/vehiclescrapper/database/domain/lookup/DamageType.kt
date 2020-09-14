package by.runets.vehiclescrapper.database.domain.lookup

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("damage_type")
class DamageType {
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
        return "DamageType(id=$id, type=$type)"
    }
}