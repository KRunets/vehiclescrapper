package by.runets.carscrapper.domain.lookup.vehicle

import by.runets.carscrapper.domain.lookup.Lookup
import org.springframework.data.relational.core.mapping.Table

@Table("vehicle_type")
data class VehicleType(val lookup: Lookup)