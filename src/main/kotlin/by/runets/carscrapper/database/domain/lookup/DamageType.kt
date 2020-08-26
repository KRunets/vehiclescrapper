package by.runets.carscrapper.database.domain.lookup

import org.springframework.data.relational.core.mapping.Table

@Table("damage_type")
data class DamageType(val lookup: Lookup)