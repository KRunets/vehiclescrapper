package by.runets.carscrapper.domain.lookup.vehicle

import by.runets.carscrapper.domain.lookup.Lookup
import org.springframework.data.relational.core.mapping.Table

@Table("make_lookup")
data class MakeLookup(
        val lookup: Lookup,
        val models: Set<ModelLookup>
)