package com.example.veriparkimkb.view.di

import com.example.veriparkimkb.view.di.handshake.HandshakeSubComponent

interface Injector {
    fun createHandshakeSubComponent(): HandshakeSubComponent
}