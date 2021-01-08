package com.example.veriparkimkb.repo

import com.example.veriparkimkb.data.model.imkb.ListResponse

interface ImkbListRepository {
    suspend fun getImkbList(): ListResponse
}