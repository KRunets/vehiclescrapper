package by.runets.carscrapper.domain.lookup

import org.springframework.data.annotation.Id
import java.util.*


data class Lookup(
        @Id
        val id: UUID,
        val type: String
)