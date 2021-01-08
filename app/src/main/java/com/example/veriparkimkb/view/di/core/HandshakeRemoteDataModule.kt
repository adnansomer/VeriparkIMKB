package com.example.veriparkimkb.view.di.core

import com.example.veriparkimkb.data.api.HandshakeService
import com.example.veriparkimkb.data.model.handshake.HandshakeRequest
import com.example.veriparkimkb.data.repository.handshake.datasource.HandshakeRemoteDataSource
import com.example.veriparkimkb.data.repository.handshake.datasourceimpl.HandshakeRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HandshakeRemoteDataModule(private val handshakeRequest: HandshakeRequest) {
    @Singleton
    @Provides
    fun provideHandshakeRemoteDataSource(handshakeService: HandshakeService): HandshakeRemoteDataSource {
        return HandshakeRemoteDataSourceImpl(handshakeService, handshakeRequest)
    }
}