package com.example.veriparkimkb.data.api

import com.example.veriparkimkb.data.model.handshake.HandshakeRequest
import com.example.veriparkimkb.data.model.handshake.HandshakeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface HandshakeService {
    @POST("api/handshake/start")
    @Headers("Content-Type: application/json")
    suspend fun requestHandshake(
        @Body request: HandshakeRequest
    ) : Response<HandshakeResponse>
}