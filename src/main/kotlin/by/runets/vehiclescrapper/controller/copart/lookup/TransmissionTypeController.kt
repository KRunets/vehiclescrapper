package by.runets.vehiclescrapper.controller.copart.lookup

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.TransmissionType
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.TransmissionTypeService
import by.runets.vehiclescrapper.utils.annotation.LogExecutionTime
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/type/transmission")
class TransmissionTypeController(@Autowired private var transmissionTypeService: TransmissionTypeService) {

    @PostMapping
    @LogExecutionTime
    suspend fun saveDamage(@RequestBody transmissionType: TransmissionType) {
        transmissionTypeService.save(transmissionType)
    }

    @GetMapping("/all")
    @LogExecutionTime
    suspend fun readAll(): Flow<TransmissionType> {
        return transmissionTypeService.findAll().asFlow()
    }
}