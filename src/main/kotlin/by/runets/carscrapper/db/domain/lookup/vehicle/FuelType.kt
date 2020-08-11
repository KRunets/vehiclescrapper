package by.runets.carscrapper.db.domain.lookup.vehicle

import by.runets.carscrapper.db.domain.lookup.Lookup
import org.springframework.data.relational.core.mapping.Table

@Table("fuel_type")
data class FuelType(val lookup: Lookup)