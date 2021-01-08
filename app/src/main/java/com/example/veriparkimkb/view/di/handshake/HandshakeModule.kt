package com.example.veriparkimkb.view.di.handshake

import com.example.veriparkimkb.repo.Handshake
import com.example.veriparkimkb.view.handshake.HandshakeViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class HandshakeModule {
    @HandshakeScope
    @Provides
    fun provideHandshake(getHandshakeUseCase: Handshake): HandshakeViewModelFactory {
        return HandshakeViewModelFactory(getHandshakeUseCase)
    }
}