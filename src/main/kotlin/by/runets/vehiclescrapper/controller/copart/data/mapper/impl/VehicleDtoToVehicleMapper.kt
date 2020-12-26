package by.runets.vehiclescrapper.controller.copart.data.mapper.impl

import by.runets.vehiclescrapper.controller.copart.data.mapper.IMapper
import by.runets.vehiclescrapper.controller.copart.dto.VehicleDto
import by.runets.vehiclescrapper.persistence.domain.Vehicle
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.stream.Collectors

@Component
class VehicleDtoToVehicleMapper(@Autowired private val modelMapper: ModelMapper) : IMapper<Set<VehicleDto>, Set<Vehicle>> {
    override fun map(dtos: Set<VehicleDto>): Set<Vehicle> {
        return dtos.stream()
                .map { dto -> toVehicle(dto) }
                .collect(Collectors.toSet())
    }

    fun toVehicle(dto: VehicleDto): Vehicle {
        return Vehicle(
                dto.make,
                dto.model,
                Integer.valueOf(dto.odometer?.split(".")?.get(0)),
                extractSaleDate(dto),
                dto.vin,
                dto.lotNumber,
                dto.year,
                dto.estimatedRetailValue,
                dto.engineType,
                dto.cylindres,
                dto.location,
                dto.timeZone,
                dto.at,
                dto.aan,
                dto.startingBid,
                dto.ss,
                dto.bndc,
                dto.bnp,
                dto.sbf,
                dto.ts,
                dto.stt,
                dto.td,
                dto.tgc,
                dto.damageType,
                dto.gr,
                dto.dtc,
                dto.al,
                dto.adt,
                dto.ynumb,
                dto.phynumb,
                dto.bf,
                dto.transmissionType,
                dto.lcc,
                dto.lcd,
                dto.fuelType,
                dto.driveTrainType,
                dto.saleStatus
        )
    }

    private fun extractSaleDate(dto: VehicleDto) : LocalDateTime? {
        if (dto.ad == null) {
            return null
        }
        return Instant.ofEpochMilli(dto.ad)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
    }

}