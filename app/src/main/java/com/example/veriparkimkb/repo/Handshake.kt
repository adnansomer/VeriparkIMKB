package com.example.veriparkimkb.repo

import com.example.veriparkimkb.data.model.handshake.HandshakeResponse

class Handshake (private val handshakeRepository: HandshakeRepository) {
    suspend fun execute() : HandshakeResponse = handshakeRepository.getHandshake()
}