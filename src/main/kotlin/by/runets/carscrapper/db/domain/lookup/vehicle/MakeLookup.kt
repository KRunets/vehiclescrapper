package by.runets.carscrapper.db.domain.lookup.vehicle

import by.runets.carscrapper.db.domain.lookup.Lookup
import org.springframework.data.relational.core.mapping.Table

@Table("make_lookup")
data class MakeLookup(
        val lookup: Lookup,
        val models: Set<ModelLookup>
)