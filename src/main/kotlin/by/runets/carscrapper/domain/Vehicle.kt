package by.runets.carscrapper.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.*

@Table("vehicle")
data class Vehicle(
        @Id
        val id: UUID,
        val model: UUID,
        val seller: UUID,
        val otherInfo: UUID,
        val odometer: Int,
        val saleDate: LocalDateTime,
        val vin: String,
        val lotNumber: String,
        var keyAmount: Int = 0,
        val series: String?,
        val startCode: String?
)