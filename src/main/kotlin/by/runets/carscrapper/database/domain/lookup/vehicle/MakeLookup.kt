package by.runets.carscrapper.database.domain.lookup.vehicle

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("make_lookup")
class MakeLookup {
    @Id
    var id: UUID? = null
    var type: String? = ""

    constructor(type: String?) {
        this.type = type
    }
}