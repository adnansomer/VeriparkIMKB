package com.example.veriparkimkb.data.api

import com.example.veriparkimkb.data.model.imkb.DetailRequest
import com.example.veriparkimkb.data.model.imkb.DetailResponse
import com.example.veriparkimkb.data.model.imkb.ListRequest
import com.example.veriparkimkb.data.model.imkb.ListResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ImkbService {

    @POST("api/stocks/list")
    @Headers("Content-Type: application/json")
    suspend fun requestList(
        @Header("X-VP-Authorization") XVPAuthorization:String,
        @Body request: ListRequest
    ) : Response<ListResponse>

    @POST("api/stocks/detail")
    @Headers("Content-Type: application/json")
    suspend fun requestDetail(
        @Header("X-VP-Authorization") XVPAuthorization:String,
        @Body request: DetailRequest
    ) : Response<DetailResponse>

}