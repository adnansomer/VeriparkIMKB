package com.example.veriparkimkb.data.model.imkb

import com.example.veriparkimkb.data.model.ServiceStatus
import com.google.gson.annotations.SerializedName

data class DetailResponse (
    @SerializedName("bid")
    val bid: Double,
    @SerializedName("channge")
    val channge: Double,
    @SerializedName("count")
    val count: Int,
    @SerializedName("difference")
    val difference: Double,
    @SerializedName("graphicData")
    val graphicData: List<Graphic>,
    @SerializedName("highest")
    val highest: Double,
    @SerializedName("isDown")
    val isDown: Boolean,
    @SerializedName("isUp")
    val isUp: Boolean,
    @SerializedName("lowest")
    val lowest: Double,
    @SerializedName("maximum")
    val maximum: Double,
    @SerializedName("minimum")
    val minimum: Double,
    @SerializedName("offer")
    val offer: Double,
    @SerializedName("price")
    val price: Double,
    @SerializedName("status")
    val status: ServiceStatus,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("volume")
    val volume: Double
)