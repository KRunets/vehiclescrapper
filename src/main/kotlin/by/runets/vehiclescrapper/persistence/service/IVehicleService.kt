package by.runets.vehiclescrapper.persistence.service

import by.runets.vehiclescrapper.persistence.domain.Vehicle
import reactor.core.publisher.Mono

interface IVehicleService {
    suspend fun findVehicleByLotNumber(lotNumber: String?): Mono<Vehicle>

    suspend fun updateVehicleDynamicDetails(vehicle: Vehicle) : Vehicle?
}