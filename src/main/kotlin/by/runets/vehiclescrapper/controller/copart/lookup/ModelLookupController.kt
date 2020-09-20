package by.runets.vehiclescrapper.controller.copart.lookup

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.ModelLookup
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.ModelLookupService
import by.runets.vehiclescrapper.utils.annotation.LogExecutionTime
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/model")
class ModelLookupController(@Autowired private var modelLookupService: ModelLookupService) {

    @PostMapping
    @LogExecutionTime
    suspend fun saveModelLookup(@RequestBody modelLookup: ModelLookup) {
        modelLookupService.save(modelLookup)
    }

    @LogExecutionTime
    @GetMapping("/all")
    suspend fun readAll(): Flow<ModelLookup> {
        return modelLookupService.findAll().asFlow()
    }

    @LogExecutionTime
    @GetMapping("/{make}")
    suspend fun readAllByMake(@PathVariable("make") make: String): Flow<ModelLookup> {
        return modelLookupService.findByMake(make).asFlow()
    }
}