package com.example.veriparkimkb.view.handshake

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.veriparkimkb.repo.Handshake

class HandshakeViewModelFactory(private val getHandshakeUseCase: Handshake):
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HandshakeViewModel(getHandshakeUseCase) as T
    }
}