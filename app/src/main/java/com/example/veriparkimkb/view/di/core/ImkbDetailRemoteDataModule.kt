package com.example.veriparkimkb.view.di.core

import com.example.veriparkimkb.data.api.ImkbService
import com.example.veriparkimkb.data.model.handshake.HandshakeResponse
import com.example.veriparkimkb.data.model.imkb.DetailRequest
import com.example.veriparkimkb.data.repository.imkbdetail.datasource.ImkbDetailRemoteDataSource
import com.example.veriparkimkb.data.repository.imkbdetail.datasourceimpl.ImkbDetailRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ImkbDetailRemoteDataModule(private val handshakeResponse: HandshakeResponse, private val detailRequest: DetailRequest) {
    @Singleton
    @Provides
    fun provideImkbDetailRemoteDataSource(imkbService: ImkbService): ImkbDetailRemoteDataSource {
        return ImkbDetailRemoteDataSourceImpl(
            imkbService,handshakeResponse,detailRequest
        )
    }
}