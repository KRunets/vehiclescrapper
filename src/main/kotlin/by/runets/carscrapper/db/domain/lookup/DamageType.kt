package by.runets.carscrapper.db.domain.lookup

import org.springframework.data.relational.core.mapping.Table

@Table("damage_type")
data class DamageType(val lookup: Lookup)