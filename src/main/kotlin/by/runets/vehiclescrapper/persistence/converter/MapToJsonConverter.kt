package by.runets.vehiclescrapper.persistence.converter
/*


import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import io.r2dbc.postgresql.codec.Json
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.WritingConverter

@WritingConverter
class MapToJsonConverter : Converter<Map<String?, Any?>?, Json?> {

    private val objectMapper: ObjectMapper? = null

    fun convert(source: Map<String?, Any?>?): Json {
        try {
            return Json.of(objectMapper.writeValueAsString(source))
        } catch (e: JsonProcessingException) {
        }
        return Json.of("")
    }
}
*/
