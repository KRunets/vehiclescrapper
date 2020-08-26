package by.runets.carscrapper.database.domain.lookup.vehicle

import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("model_lookup")
data class ModelLookup(
        val id: UUID,
        val make: UUID,
        val model: String,
        val vehicleType: UUID,
        val bodyStyle: UUID,
        val fuelType: UUID,
        val transmissionType: UUID,
        val driveTrain: UUID
)