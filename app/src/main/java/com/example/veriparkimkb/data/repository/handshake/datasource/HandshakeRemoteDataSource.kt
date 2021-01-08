package com.example.veriparkimkb.data.repository.handshake.datasource

import com.example.veriparkimkb.data.model.handshake.HandshakeResponse
import retrofit2.Response

interface HandshakeRemoteDataSource  {
    suspend fun getHandshake(): Response<HandshakeResponse>
}