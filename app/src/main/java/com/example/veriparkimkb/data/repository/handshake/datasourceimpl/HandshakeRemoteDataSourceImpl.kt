package com.example.veriparkimkb.data.repository.handshake.datasourceimpl

import com.example.veriparkimkb.data.api.HandshakeService
import com.example.veriparkimkb.data.model.handshake.HandshakeRequest
import com.example.veriparkimkb.data.model.handshake.HandshakeResponse
import com.example.veriparkimkb.data.repository.handshake.datasource.HandshakeRemoteDataSource
import retrofit2.Response

class HandshakeRemoteDataSourceImpl(
    private val handshakeService: HandshakeService,
    private val handshakeRequest: HandshakeRequest
) :
    HandshakeRemoteDataSource {
    override suspend fun getHandshake() : Response<HandshakeResponse> = handshakeService.requestHandshake(handshakeRequest)
}