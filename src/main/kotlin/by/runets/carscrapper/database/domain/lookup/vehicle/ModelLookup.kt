package by.runets.carscrapper.database.domain.lookup.vehicle

import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("model_lookup")
data class ModelLookup(
        private val id: UUID,
        private val make: UUID,
        private val model: String,
        private val vehicleType: UUID,
        private val bodyStyle: UUID,
        private val fuelType: UUID,
        private val transmissionType: UUID,
        private val driveTrain: UUID
)