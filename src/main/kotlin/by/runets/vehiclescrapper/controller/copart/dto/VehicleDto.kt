package by.runets.vehiclescrapper.controller.copart.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class VehicleDto(
        @JsonProperty("lotNumberStr")
        val lotNumber: String?,
        @JsonProperty("mkn")
        val make: String?,
        @JsonProperty("lm")
        val model: String?,
        @JsonProperty("lcy")
        val year: String?,
        @JsonProperty("fv")
        val vin: String?,
        @JsonProperty("la")
        val estimatedRetailValue: String?,
        @JsonProperty("orr")
        val odometer: String?,
        @JsonProperty("egn")
        val engineType: String?,
        @JsonProperty("cy")
        val cylindres: String?,
        @JsonProperty("yn")
        val location: String?,
        @JsonProperty("tz")
        val timeZone: String?,
        @JsonProperty("at")
        val at: String?,
        @JsonProperty("aan")
        val aan: String?,
        @JsonProperty("hb")
        val startingBid: String?,
        @JsonProperty("ss")
        val ss: String?,
        @JsonProperty("bndc")
        val bndc: String?,
        @JsonProperty("bnp")
        val bnp: String?,
        @JsonProperty("sbf")
        val sbf: String?,
        @JsonProperty("ts")
        val ts: String?,
        @JsonProperty("stt")
        val stt: String?,
        @JsonProperty("td")
        val td: String?,
        @JsonProperty("tgc")
        val tgc: String?,
        @JsonProperty("dd")
        val damageType: String?,
        @JsonProperty("gr")
        val gr: String?,
        @JsonProperty("dtc")
        val dtc: String?,
        @JsonProperty("al")
        val al: String?,
        @JsonProperty("ad")
        val ad: Long?,
        @JsonProperty("adt")
        val adt: String?,
        @JsonProperty("ynumb")
        val ynumb: String?,
        @JsonProperty("phynumb")
        val phynumb: String?,
        @JsonProperty("bf")
        val bf: String?,
        @JsonProperty("tmtp")
        val transmissionType: String?,
        @JsonProperty("lcc")
        val lcc: String?,
        @JsonProperty("lcd")
        val lcd: String?,
        @JsonProperty("ft")
        val fuelType: String?,
        @JsonProperty("drv")
        val driveTrainType: String?,
        @JsonProperty("ess")
        val saleStatus: String?)