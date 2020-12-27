package by.runets.vehiclescrapper.persistence.service

import by.runets.vehiclescrapper.persistence.domain.Vehicle
import reactor.core.publisher.Mono
import java.util.*

interface IVehicleService {
    suspend fun findVehicleByLotNumber(lotNumber: String?): Mono<Vehicle>
}