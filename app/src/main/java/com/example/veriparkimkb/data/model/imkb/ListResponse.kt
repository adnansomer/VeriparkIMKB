package com.example.veriparkimkb.data.model.imkb

import com.example.veriparkimkb.data.model.ServiceStatus
import com.google.gson.annotations.SerializedName

data class ListResponse (
    @SerializedName("status")
    val status: ServiceStatus,
    @SerializedName("stocks")
    val stocks: List<Stock>
)