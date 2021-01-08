package com.example.veriparkimkb.data.repository.handshake.datasource

import com.example.veriparkimkb.data.model.handshake.HandshakeResponse

interface HandshakeCacheDataSource {
    suspend fun getHandshakeFromCache(): HandshakeResponse
    suspend fun saveHandshakeToCache(response: HandshakeResponse)
}