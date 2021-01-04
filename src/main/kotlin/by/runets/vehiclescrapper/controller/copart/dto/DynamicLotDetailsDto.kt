package by.runets.vehiclescrapper.controller.copart.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class DynamicLotDetailsDto(
        @JsonProperty("buyerNumber")
        val buyerNumber : String?,
        @JsonProperty("source")
        val source : String?,
        @JsonProperty("buyTodayBid")
        val buyTodayBid : String?,
        @JsonProperty("currentBid")
        val currentBid : String?,
        @JsonProperty("totalAmountDue")
        val totalAmountDue : String?,
        @JsonProperty("sealedBid")
        val sealedBid : Boolean?,
        @JsonProperty("firstBid")
        val firstBid : Boolean?,
        @JsonProperty("hasBid")
        val hasBid : Boolean?,
        @JsonProperty("sellerReserveMet")
        val sellerReserveMet : Boolean?,
        @JsonProperty("lotSold")
        val lotSold : Boolean?,
        @JsonProperty("bidStatus")
        val bidStatus : String?,
        @JsonProperty("saleStatus")
        val saleStatus : String?,
        @JsonProperty("counterBidStatus")
        val counterBidStatus : String?,
        @JsonProperty("buyerHighBidder")
        val buyerHighBidder : Boolean?
)