package by.runets.carscrapper.domain

import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("other_info")
data class OtherInfo(
        val id: UUID,
        val infoContext: Map<String, List<String>>
)