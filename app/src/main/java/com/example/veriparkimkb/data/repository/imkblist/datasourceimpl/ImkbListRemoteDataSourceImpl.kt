package com.example.veriparkimkb.data.repository.imkblist.datasourceimpl

import com.example.veriparkimkb.data.api.ImkbService
import com.example.veriparkimkb.data.model.handshake.HandshakeResponse
import com.example.veriparkimkb.data.model.imkb.ListRequest
import com.example.veriparkimkb.data.model.imkb.ListResponse
import com.example.veriparkimkb.data.repository.imkblist.datasource.ImkbListRemoteDataSource
import retrofit2.Response

class ImkbListRemoteDataSourceImpl(
    private val imkbService: ImkbService,
    private val handshakeResponse: HandshakeResponse,
    private val listRequest: ListRequest
) : ImkbListRemoteDataSource {
    override suspend fun getImkbList(): Response<ListResponse> = imkbService.requestList(handshakeResponse.authorization,listRequest)

}