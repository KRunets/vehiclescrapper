package by.runets.carscrapper.domain.lookup.vehicle

import by.runets.carscrapper.domain.lookup.Lookup
import org.springframework.data.relational.core.mapping.Table

@Table("transmission_type")
data class TransmissionType(val lookup: Lookup)