package by.runets.carscrapper.db.domain.lookup.vehicle

import by.runets.carscrapper.db.domain.lookup.Lookup
import org.springframework.data.relational.core.mapping.Table

@Table("body_style_type")
data class BodyStyleType(val lookup: Lookup)