package com.example.veriparkimkb.repo

import com.example.veriparkimkb.data.model.handshake.HandshakeResponse

interface HandshakeRepository {
    suspend fun getHandshake(): HandshakeResponse
}