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
        val MODL = "MODL"
        val TRANSMISSION_TYPE = "TMTP"

        val VALUE_ATTRIBUTE = "value"

        val MODEL_COLLAPSIBLE_PANEL = "collapseinside4"
        val DAMAGE_COLLAPSIBLE_PANEL = "collapseinside13"
        val BODY_STYLE_COLLAPSIBLE_PANEL = "collapseinside14"
        val FUEL_COLLAPSIBLE_PANEL = "collapseinside15"
        val ENGINE_COLLAPSIBLE_PANEL = "collapseinside16"
        val TRANSMISSION_COLLAPSIBLE_PANEL = "collapseinside17"

        val MODEL_COLLAPSIBLE_BTN = "//a[@href='#collapseinside4']"
        val DAMAGE_COLLAPSIBLE_BTN = "//a[@href='#collapseinside13']"
        val BODY_STYLE_COLLAPSIBLE_BTN = "//a[@href='#collapseinside14']"
        val FUEL_COLLAPSIBLE_BTN = "//a[@href='#collapseinside15']"
        val ENGINE_COLLAPSIBLE_BTN = "//a[@href='#collapseinside16']"
        val TRANSMISSION_COLLAPSIBLE_BTN = "//a[@href='#collapseinside17']"
    }
}