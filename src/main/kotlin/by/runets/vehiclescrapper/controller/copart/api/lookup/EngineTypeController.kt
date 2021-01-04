package by.runets.vehiclescrapper.controller.copart.api.lookup

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.EngineType
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.EngineTypeTypeService
import by.runets.vehiclescrapper.utils.annotation.LogExecutionTime
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/type/engine")
class EngineTypeController(@Autowired private var engineTypeService: EngineTypeTypeService) {

    @PostMapping
    @LogExecutionTime
    suspend fun saveDamage(@RequestBody engineType: EngineType) {
        engineTypeService.save(engineType)
    }

    @GetMapping("/all")
    @LogExecutionTime
    suspend fun readAll(): Flow<EngineType> {
        return engineTypeService.findAll().asFlow()
    }
}