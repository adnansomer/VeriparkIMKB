package com.example.veriparkimkb.data.repository.imkbdetail.datasourceimpl

import com.example.veriparkimkb.data.api.ImkbService
import com.example.veriparkimkb.data.model.handshake.HandshakeResponse
import com.example.veriparkimkb.data.model.imkb.DetailRequest
import com.example.veriparkimkb.data.model.imkb.DetailResponse
import com.example.veriparkimkb.data.repository.imkbdetail.datasource.ImkbDetailRemoteDataSource
import retrofit2.Response

class ImkbDetailRemoteDataSourceImpl(
    private val imkbService: ImkbService,
    private val handshakeResponse: HandshakeResponse,
    private val detailRequest: DetailRequest
) : ImkbDetailRemoteDataSource {

    override suspend fun getImkbDetail(): Response<DetailResponse> = imkbService.requestDetail(handshakeResponse.authorization,detailRequest)
}