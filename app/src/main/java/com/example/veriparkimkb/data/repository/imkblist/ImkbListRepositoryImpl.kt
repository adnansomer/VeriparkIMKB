package com.example.veriparkimkb.data.repository.imkblist

import android.util.Log
import com.example.veriparkimkb.data.model.ServiceError
import com.example.veriparkimkb.data.model.ServiceStatus
import com.example.veriparkimkb.data.model.imkb.ListResponse
import com.example.veriparkimkb.data.repository.imkblist.datasource.ImkbListRemoteDataSource
import com.example.veriparkimkb.repo.ImkbListRepository
import java.lang.Exception

class ImkbListRepositoryImpl(private val imkbListRemoteDataSource: ImkbListRemoteDataSource) : ImkbListRepository {

    override suspend fun getImkbList(): ListResponse {
        return getImkbListFromAPI()
    }

    suspend fun getImkbListFromAPI(): ListResponse {
        lateinit var response: ListResponse
        response = ListResponse(ServiceStatus(ServiceError(0,""),false), emptyList())
        try {
            val body = imkbListRemoteDataSource.getImkbList().body()
            if (body != null) response = body
        } catch (exception: Exception) {
            Log.e("Error", exception.message.toString())
            //exception.printStackTrace()
        }
        return response
    }
}