package com.example.veriparkimkb.data.repository.handshake

import android.util.Log
import com.example.veriparkimkb.data.model.handshake.HandshakeResponse
import com.example.veriparkimkb.data.model.imkb.DetailResponse
import com.example.veriparkimkb.data.repository.handshake.datasource.HandshakeCacheDataSource
import com.example.veriparkimkb.data.repository.handshake.datasource.HandshakeRemoteDataSource
import com.example.veriparkimkb.data.repository.imkbdetail.datasource.ImkbDetailRemoteDataSource
import com.example.veriparkimkb.repo.HandshakeRepository
import com.example.veriparkimkb.repo.ImkbDetailRepository
import java.lang.Exception

class HandshakeRepositoryImpl(
    private val handshakeRemoteDataSource: HandshakeRemoteDataSource,
    private val handshakeCacheDataSource: HandshakeCacheDataSource
) : HandshakeRepository {

    override suspend fun getHandshake(): HandshakeResponse {
        return getHandshakeFromCache()
    }

    suspend fun getHandshakeFromAPI(): HandshakeResponse {
        lateinit var response: HandshakeResponse
        try {
            val body = handshakeRemoteDataSource.getHandshake().body()
            if (body != null) response = body
        } catch (exception: Exception) {
            Log.e("AppError", exception.message.toString())
        }
        return response
    }

    suspend fun getHandshakeFromCache(): HandshakeResponse {
        lateinit var response: HandshakeResponse
        try {
            response = handshakeCacheDataSource.getHandshakeFromCache()
        } catch (exception: Exception) {
            Log.e("AppError", exception.message.toString())
        }
        if (true) {
            response = getHandshakeFromAPI()
            handshakeCacheDataSource.saveHandshakeToCache(response)
        }
        return response
    }

}