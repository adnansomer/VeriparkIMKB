package com.example.veriparkimkb.view.di.core

import android.content.Context
import com.example.veriparkimkb.view.di.handshake.HandshakeSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [HandshakeSubComponent::class])
class AppModule(private val context : Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}