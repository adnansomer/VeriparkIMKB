package com.example.veriparkimkb.view.di.core

import com.example.veriparkimkb.data.model.handshake.HandshakeRequest
import dagger.Module

@Module
class RemoteDataModule(private val handshakeRequest: HandshakeRequest) {
}