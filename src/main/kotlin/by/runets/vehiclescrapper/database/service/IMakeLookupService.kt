package by.runets.vehiclescrapper.database.service

import by.runets.vehiclescrapper.database.domain.lookup.vehicle.MakeLookup

interface IMakeLookupService {
    suspend fun findByType(type: String): MakeLookup
}