package com.example.veriparkimkb.data.model.handshake

import com.example.veriparkimkb.data.model.ServiceStatus
import com.google.gson.annotations.SerializedName

data class HandshakeResponse (
    @SerializedName("aesIV")
    val aesIV: String,
    @SerializedName("aesKey")
    val aesKey: String,
    @SerializedName("authorization")
    val authorization: String,
    @SerializedName("lifeTime")
    val lifeTime: String,
    @SerializedName("status")
    val status: ServiceStatus
)