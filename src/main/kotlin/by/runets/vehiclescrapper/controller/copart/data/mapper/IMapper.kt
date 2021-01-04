package by.runets.vehiclescrapper.controller.copart.data.mapper

interface IMapper<S, T> {
    fun map(s: S): T

    fun mapAll(s: Set<S>): Set<T>
}