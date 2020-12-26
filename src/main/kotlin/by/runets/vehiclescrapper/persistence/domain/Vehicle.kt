package by.runets.vehiclescrapper.persistence.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.*

@Table("vehicle")
class Vehicle(make: String?,
              model: String?,
              odometer: Int?,
              saleDate: LocalDateTime?,
              vin: String?,
              lotNumber: String?,
              year: String?,
              estimatedRetailValue: String?,
              engineType: String?,
              cylindres: String?,
              location: String?,
              timeZone: String?,
              at: String?,
              aan: String?,
              startingBid: String?,
              ss: String?,
              bndc: String?,
              bnp: String?,
              sbf: String?,
              ts: String?,
              stt: String?,
              td: String?,
              tgc: String?,
              damageType: String?,
              gr: String?,
              dtc: String?,
              al: String?,
              adt: String?,
              ynumb: String?,
              phynumb: String?,
              bf: String?,
              transmissionType: String?,
              lcc: String?,
              lcd: String?,
              fuelType: String?,
              driveTrainType: String?,
              saleStatus: String?) {
        @Id
        var id: UUID? = null
        val make: String? = make
        val model: String? = model
        val odometer: Int? = odometer
        val saleDate: LocalDateTime? = saleDate
        val vin: String? = vin
        val lotNumber: String? = lotNumber
        val year: String? = year
        val estimatedRetailValue: String? = estimatedRetailValue
        val engineType: String? = engineType
        val cylindres: String? = cylindres
        val location: String? = location
        val timeZone: String? = timeZone
        val at: String? = at
        val aan: String? = aan
        val startingBid: String? = startingBid
        val ss: String? = ss
        val bndc: String? = bndc
        val bnp: String? = bnp
        val sbf: String? = sbf
        val ts: String? = ts
        val stt: String? = stt
        val td: String? = td
        val tgc: String? = tgc
        val damageType: String? = damageType
        val gr: String? = gr
        val dtc: String? = dtc
        val al: String? = al
        val adt: String? = adt
        val ynumb: String? = ynumb
        val phynumb: String? = phynumb
        val bf: String? = bf
        val transmissionType: String? = transmissionType
        val lcc: String? = lcc
        val lcd: String? = lcd
        val fuelType: String? = fuelType
        val driveTrainType: String? = driveTrainType
        val saleStatus: String? = saleStatus
}