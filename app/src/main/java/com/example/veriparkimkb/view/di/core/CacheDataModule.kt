package com.example.veriparkimkb.view.di.core

import com.example.veriparkimkb.data.repository.handshake.datasource.HandshakeCacheDataSource
import com.example.veriparkimkb.data.repository.handshake.datasourceimpl.HandshakeCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideHandshakeCacheDataSource(): HandshakeCacheDataSource {
        return HandshakeCacheDataSourceImpl()
    }
}