package by.runets.vehiclescrapper.controller.copart.lookup

import by.runets.vehiclescrapper.persistence.domain.lookup.DamageType
import by.runets.vehiclescrapper.persistence.service.lookup.DamageTypeService
import by.runets.vehiclescrapper.utils.annotation.LogExecutionTime
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/type/damage")
class DamageTypeController(@Autowired private var damageTypeService: DamageTypeService) {

    @PostMapping
    @LogExecutionTime
    suspend fun saveDamage(@RequestBody damageType: DamageType) {
        damageTypeService.save(damageType)
    }

    @GetMapping("/all")
    @LogExecutionTime
    suspend fun readAll(): Flow<DamageType> {
        return damageTypeService.findAll().asFlow()
    }
}