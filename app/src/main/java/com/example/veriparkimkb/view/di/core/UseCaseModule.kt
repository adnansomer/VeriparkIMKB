package com.example.veriparkimkb.view.di.core

import com.example.veriparkimkb.repo.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetHandshakeUseCase(handshakeRepository: HandshakeRepository):Handshake{
        return Handshake(handshakeRepository)
    }
    @Provides
    fun provideGetImkbListUseCase(imkbRepository: ImkbListRepository):ImkbList{
        return ImkbList(imkbRepository)
    }
    @Provides
    fun provideGetImkbDetailUseCase(imkbRepository: ImkbDetailRepository, aesEncryptedPeriod:String): ImkbDetail {
        return ImkbDetail(imkbRepository,aesEncryptedPeriod)
    }
}