package by.runets.vehiclescrapper.utils.coroutines

import kotlinx.coroutines.reactor.mono
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

fun <T> Flux<T>.onNext(block: suspend (T) -> Unit): Flux<T> {
    return this.flatMap {
        mono {
            block.invoke(it)
        }.thenMany(Flux.just(it))
    }
}

fun <T> Mono<T>.onNext(block: suspend (T) -> Unit): Mono<T> {
    return this.flatMap {
        mono {
            block.invoke(it)
        }.then(Mono.just(it))
    }
}

fun <T> Flux<T>.onError(block: suspend (Throwable) -> Unit): Flux<T> {
    return this.onErrorResume {
        mono {
            block.invoke(it)
        }.thenMany(Flux.error(it))
    }
}

fun <T> Mono<T>.onError(block: suspend (Throwable) -> Unit): Mono<T> {
    return this.onErrorResume {
        mono {
            block.invoke(it)
        }.then(Mono.error(it))
    }
}