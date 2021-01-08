package com.example.veriparkimkb.repo

import com.example.veriparkimkb.data.model.imkb.ListResponse

class ImkbList (private val imkbRepository:ImkbListRepository) {
    suspend fun execute(): ListResponse = imkbRepository.getImkbList()
}