package com.example.veriparkimkb.view.di.core

import com.example.veriparkimkb.view.di.handshake.HandshakeSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        HandshakeRemoteDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {
    fun handshakeSubComponent(): HandshakeSubComponent.Factory
}