package by.runets.carscrapper.database.service

import by.runets.carscrapper.database.domain.lookup.vehicle.MakeLookup

interface IMakeLookupService {
    suspend fun findByType(type: String): MakeLookup
}