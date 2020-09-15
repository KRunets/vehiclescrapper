package by.runets.vehiclescrapper.scrapper.copart.utils

class HtmlTagUtils {
    companion object {
        val LIST_GROUP_ITEM = "list-group-item"
        val PANEL_DEFAULT = "panel-default"
        val PANEL_HEADING = "panel-heading"
        val POPULAR_MAKES = "Popular Makes"

        val BODY = "BODY"
        val FUEL = "FUEL"
        val DAMAGE = "PRID"
        val ENGN = "ENGN"
        val TRANSMISSION_TYPE = "TMTP"

        val VALUE_ATTRIBUTE = "value"

        val DAMAGE_COLLAPSIBLE_PANEL = "collapseinside13"
        val BODY_STYLE_COLLAPSIBLE_PANEL = "collapseinside14"
        val ENGINE_COLLAPSIBLE_PANEL = "collapseinside16"

        val DAMAGE_COLLAPSIBLE_BTN = "//a[@href='#collapseinside13']"
        val BODY_STYLE_COLLAPSIBLE_BTN = "//a[@href='#collapseinside14']"
        val ENGINE_COLLAPSIBLE_BTN = "//a[@href='#collapseinside16']"
    }
}