package by.runets.vehiclescrapper.controller.copart

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup
import by.runets.vehiclescrapper.persistence.service.lookup.vehicle.MakeLookupService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/make")
class MakeLookupController(@Autowired private var makeLookupService: MakeLookupService) {

    @PostMapping
    suspend fun saveMakeLookup(@RequestBody makeLookup: MakeLookup) {
        makeLookupService.save(makeLookup)
    }

    @GetMapping("/all")
    suspend fun readAll(): Flow<MakeLookup> {
        return makeLookupService.findAll().asFlow()
    }
}