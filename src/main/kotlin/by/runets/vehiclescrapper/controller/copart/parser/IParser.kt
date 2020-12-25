package by.runets.vehiclescrapper.controller.copart.parser

interface IParser<S, T> {
    fun parse(obj : S) : T
}