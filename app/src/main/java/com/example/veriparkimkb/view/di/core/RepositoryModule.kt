package com.example.veriparkimkb.view.di.core

import com.example.veriparkimkb.data.repository.handshake.HandshakeRepositoryImpl
import com.example.veriparkimkb.data.repository.handshake.datasource.HandshakeCacheDataSource
import com.example.veriparkimkb.data.repository.handshake.datasource.HandshakeRemoteDataSource
import com.example.veriparkimkb.data.repository.imkbdetail.ImkbDetailRepositoryImpl
import com.example.veriparkimkb.data.repository.imkbdetail.datasource.ImkbDetailRemoteDataSource
import com.example.veriparkimkb.data.repository.imkblist.ImkbListRepositoryImpl
import com.example.veriparkimkb.data.repository.imkblist.datasource.ImkbListRemoteDataSource
import com.example.veriparkimkb.repo.HandshakeRepository
import com.example.veriparkimkb.repo.ImkbDetailRepository
import com.example.veriparkimkb.repo.ImkbListRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideHandshakeRepository(
        handshakeRemoteDataSource: HandshakeRemoteDataSource,
        handshakeCacheDataSource: HandshakeCacheDataSource
    ): HandshakeRepository {
        return HandshakeRepositoryImpl(
            handshakeRemoteDataSource,
            handshakeCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideImkbListRepository(
        ImkbRemoteDataSource: ImkbListRemoteDataSource
    ): ImkbListRepository {
        return ImkbListRepositoryImpl(
            ImkbRemoteDataSource
        )
    }

    @Provides
    @Singleton
    fun provideImkbDetailRepository(
        ImkbRemoteDataSource: ImkbDetailRemoteDataSource
    ): ImkbDetailRepository {
        return ImkbDetailRepositoryImpl(
            ImkbRemoteDataSource
        )
    }
}