package by.runets.vehiclescrapper.persistence.domain.lookup.vehicle

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("engine_type")
class EngineType(type: String?, makeLookupId: UUID?) {

    @Id
    var id: UUID? = null
    var type: String? = type
    var makeLookupId: UUID? = makeLookupId

    override fun toString(): String {
        return "EngineType(id=$id, type=$type, makeLookupId=$makeLookupId)"
    }
}