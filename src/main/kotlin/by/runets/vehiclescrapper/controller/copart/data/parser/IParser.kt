package by.runets.vehiclescrapper.controller.copart.data.parser

interface IParser<S, T> {
    fun parse(obj : S) : T
}