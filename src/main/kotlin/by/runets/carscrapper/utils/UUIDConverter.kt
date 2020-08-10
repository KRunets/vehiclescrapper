package by.runets.carscrapper.utils

import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.WritingConverter
import java.util.*

@WritingConverter
class UUIDConverter : Converter<UUID, UUID> {
    override fun convert(source: UUID): UUID {
        return source
    }
}
