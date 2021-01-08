package com.example.veriparkimkb.data.repository.handshake.datasourceimpl

import com.example.veriparkimkb.data.model.handshake.HandshakeResponse
import com.example.veriparkimkb.data.repository.handshake.datasource.HandshakeCacheDataSource
import com.example.veriparkimkb.util.Date

class HandshakeCacheDataSourceImpl : HandshakeCacheDataSource {
    private lateinit var handshakeResponse: HandshakeResponse

    override suspend fun getHandshakeFromCache(): HandshakeResponse {
        if (handshakeResponse != null) {
            if (Date.isLifetimeValid(handshakeResponse.lifeTime)) return handshakeResponse
        }
        return handshakeResponse
    }

    override suspend fun saveHandshakeToCache(response: HandshakeResponse) {
        handshakeResponse = response
    }

}
