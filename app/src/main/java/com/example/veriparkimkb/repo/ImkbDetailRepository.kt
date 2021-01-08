package com.example.veriparkimkb.repo

import com.example.veriparkimkb.data.model.imkb.DetailResponse

interface ImkbDetailRepository {
    suspend fun getImkbDetail(aesEncryptedID:String): DetailResponse
}