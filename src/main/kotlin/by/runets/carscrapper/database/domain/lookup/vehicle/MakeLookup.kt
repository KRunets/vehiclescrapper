package by.runets.carscrapper.database.domain.lookup.vehicle

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

//ToDo Need to sync up POJO with db schema
@Table("make_lookup")
class MakeLookup {
    @Id
    var id: UUID? = null
    var type: String?

    constructor(type: String?) {
        this.type = type
    }

    override fun toString(): String {
        return "MakeLookup(type=$type, id=$id"
    }
}