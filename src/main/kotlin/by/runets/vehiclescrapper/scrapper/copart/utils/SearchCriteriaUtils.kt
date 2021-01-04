package by.runets.vehiclescrapper.scrapper.copart.utils

class SearchCriteriaUtils {
    companion object {
        val SEARCH_CRITERIA_TEMPLATE = "searchCriteria={\n" +
                "  \"query\": [\n" +
                "    \"*\"\n" +
                "  ],\n" +
                "  \"filter\": {\n" +
                "    \"ENGN\": [\n" +
                "      \"engine:\\\"{ENGINE_VALUE}\\\"\"\n" +
                "    ],\n" +
                "    \"FUEL\": [\n" +
                "      \"fuel_type_desc:\\\"{FUEL_TYPE_VALUE}\\\"\"\n" +
                "    ],\n" +
                "    \"MISC\": [\n" +
                "      \"lot_make_desc:{LOT_MAKE_DESCRIPTION_VALUE}\"\n" +
                "    ],\n" +
                "    \"MODL\": [\n" +
                "      \"lot_model_desc:\\\"{LOT_MODEL_DESCRIPTION_VALUE}\\\"\"\n" +
                "    ],\n" +
                "    \"PRID\": [\n" +
                "      \"damage_type_code:{DAMAGECODE_VALUE}\"\n" +
                "    ],\n" +
                "    \"TMTP\": [\n" +
                "      \"transmission_type:\\\"{TRANSMISSION_TYPE_VALUE}\\\"\"\n" +
                "    ],\n" +
                "    \"YEAR\": [\n" +
                "      \"lot_year:\\\"{LOT_YEAR_VALUE}\\\"\"\n" +
                "    ]\n" +
                "  },\n" +
                "  \"sort\": [\n" +
                "    \"auction_date_type desc\",\n" +
                "    \"auction_date_utc asc\"\n" +
                "  ],\n" +
                "  \"watchListOnly\": false,\n" +
                "  \"searchName\": \"\",\n" +
                "  \"freeFormSearch\": false\n" +
                "}"
    }

}