package by.runets.vehiclescrapper.utils

import org.openqa.selenium.json.Json
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.WritingConverter

@WritingConverter
class JsonConverter : Converter<Json, Json> {
    override fun convert(p0: Json): Json? {
        return p0
    }
}