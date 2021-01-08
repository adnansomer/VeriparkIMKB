package com.example.veriparkimkb.data.repository.imkbdetail.datasource

import com.example.veriparkimkb.data.model.imkb.DetailResponse
import retrofit2.Response

interface ImkbDetailRemoteDataSource {
    suspend fun getImkbDetail(): Response<DetailResponse>
}