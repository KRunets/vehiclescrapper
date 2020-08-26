package by.runets.carscrapper.database.domain.lookup.vehicle

import by.runets.carscrapper.database.domain.lookup.Lookup
import org.springframework.data.relational.core.mapping.Table

@Table("vehicle_type")
data class VehicleType(val lookup: Lookup)