package by.runets.vehiclescrapper.persistence.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.*

@Table("vehicle")
data class Vehicle(
        @Id
        private val id: UUID,
        private val model: UUID,
        private val seller: UUID,
        private val odometer: Int,
        private val saleDate: LocalDateTime,
        private val vin: String,
        private val lotNumber: String,
        private var keyAmount: Int = 0,
        private val series: String?,
        private val startCode: String?
)