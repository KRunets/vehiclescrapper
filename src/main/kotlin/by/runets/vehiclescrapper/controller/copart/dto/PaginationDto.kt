package by.runets.vehiclescrapper.controller.copart.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class PaginationDto (@JsonProperty("totalElements") private val size : Int)
