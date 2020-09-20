package by.runets.vehiclescrapper.controller.copart.lookup

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.FuelType
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.FuelTypeService
import by.runets.vehiclescrapper.utils.annotation.LogExecutionTime
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/type/fuel")
class FuelTypeController(@Autowired private var fuelTypeService: FuelTypeService) {

    @PostMapping
    @LogExecutionTime
    suspend fun saveDamage(@RequestBody fuelType: FuelType) {
        fuelTypeService.save(fuelType)
    }

    @GetMapping("/all")
    @LogExecutionTime
    suspend fun readAll(): Flow<FuelType> {
        return fuelTypeService.findAll().asFlow()
    }
}