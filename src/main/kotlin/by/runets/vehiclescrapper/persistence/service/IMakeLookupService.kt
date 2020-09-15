package by.runets.vehiclescrapper.persistence.service

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.MakeLookup

interface IMakeLookupService {
    suspend fun findByType(type: String): MakeLookup
}