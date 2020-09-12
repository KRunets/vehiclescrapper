package by.runets.carscrapper.database.domain

import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("other_info")
data class OtherInfo(
        private val id: UUID,
        private val infoContext: Map<String, List<String>>
)