package com.example.veriparkimkb.view.di.core

import com.example.veriparkimkb.data.api.ImkbService
import com.example.veriparkimkb.data.model.handshake.HandshakeResponse
import com.example.veriparkimkb.data.model.imkb.ListRequest
import com.example.veriparkimkb.data.repository.imkblist.datasource.ImkbListRemoteDataSource
import com.example.veriparkimkb.data.repository.imkblist.datasourceimpl.ImkbListRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ImkbListRemoteDataModule(
    private val handshakeResponse: HandshakeResponse,
    private val listRequest: ListRequest
) {
    @Singleton
    @Provides
    fun provideImkbListRemoteDataSource(imkbService: ImkbService): ImkbListRemoteDataSource {
        return ImkbListRemoteDataSourceImpl(
            imkbService, handshakeResponse, listRequest
        )
    }
}