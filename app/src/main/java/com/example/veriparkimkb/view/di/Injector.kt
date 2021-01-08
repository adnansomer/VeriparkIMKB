package com.example.veriparkimkb.view.di

import com.example.veriparkimkb.view.di.handshake.HandshakeSubComponent

interface Injector {
    //fun createImkbDetailSubComponent():ImkbDetailSubComponent
    //fun createImkbListSubComponent(): ImkbListSubComponent
    fun createHandshakeSubComponent(): HandshakeSubComponent
}