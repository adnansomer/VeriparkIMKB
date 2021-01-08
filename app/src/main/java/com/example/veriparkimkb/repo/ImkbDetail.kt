package com.example.veriparkimkb.repo

import com.example.veriparkimkb.data.model.imkb.DetailResponse

class ImkbDetail(private val imkbRepository: ImkbDetailRepository, private val aesEncryptedID:String) {
    suspend fun execute(): DetailResponse = imkbRepository.getImkbDetail(aesEncryptedID)
}