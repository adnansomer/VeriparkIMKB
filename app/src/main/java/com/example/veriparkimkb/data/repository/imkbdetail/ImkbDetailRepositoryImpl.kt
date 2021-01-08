package com.example.veriparkimkb.data.repository.imkbdetail

import android.util.Log
import com.example.veriparkimkb.data.model.imkb.DetailResponse
import com.example.veriparkimkb.data.repository.imkbdetail.datasource.ImkbDetailRemoteDataSource
import com.example.veriparkimkb.repo.ImkbDetailRepository
import java.lang.Exception

class ImkbDetailRepositoryImpl(private val imkbRemoteDataSource: ImkbDetailRemoteDataSource) :
    ImkbDetailRepository {

    override suspend fun getImkbDetail(aesEncryptedID: String): DetailResponse {
        return getImkbDetailFromAPI()
    }

    suspend fun getImkbDetailFromAPI(): DetailResponse {
        lateinit var response: DetailResponse
        try {
            val body = imkbRemoteDataSource.getImkbDetail().body()
            if (body != null) response = body
        } catch (exception: Exception) {
            //Log.e("Error", exception.message.toString())
        }
        return response
    }
}