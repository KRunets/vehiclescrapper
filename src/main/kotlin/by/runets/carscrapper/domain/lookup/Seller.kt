package by.runets.carscrapper.domain.lookup

import org.springframework.data.relational.core.mapping.Table

@Table("seller")
data class Seller(val lookup: Lookup)