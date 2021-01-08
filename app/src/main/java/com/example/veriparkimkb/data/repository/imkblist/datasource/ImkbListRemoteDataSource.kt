package com.example.veriparkimkb.data.repository.imkblist.datasource

import com.example.veriparkimkb.data.model.imkb.ListResponse
import retrofit2.Response

interface ImkbListRemoteDataSource {
    suspend fun getImkbList(): Response<ListResponse>
}