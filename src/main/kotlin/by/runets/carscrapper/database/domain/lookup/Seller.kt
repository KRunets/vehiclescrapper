package by.runets.carscrapper.database.domain.lookup

import org.springframework.data.relational.core.mapping.Table

@Table("seller")
data class Seller(val lookup: Lookup)