package by.runets.vehiclescrapper.utils

import by.runets.vehiclescrapper.persistence.domain.lookup.vehicle.EngineType
import reactor.core.publisher.Flux

class FluxUtils {
    companion object {
        fun diff(flux1: Flux<EngineType>, flux2: Flux<EngineType>) {
            flux1.filterWhen { remoteTweet -> flux2.hasElement(remoteTweet).map { hasElement -> !hasElement } }
                    .subscribe(System.out::println)
        }
    }
}