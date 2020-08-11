package by.runets.carscrapper.db.domain.lookup.vehicle

import by.runets.carscrapper.db.domain.lookup.Lookup
import org.springframework.data.relational.core.mapping.Table

@Table("transmission_type")
data class TransmissionType(val lookup: Lookup)