package com.example.veriparkimkb.view.di.handshake

import com.example.veriparkimkb.MainActivity
import dagger.Subcomponent

@HandshakeScope
@Subcomponent(modules = [HandshakeModule::class])
interface HandshakeSubComponent {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): HandshakeSubComponent
    }
}