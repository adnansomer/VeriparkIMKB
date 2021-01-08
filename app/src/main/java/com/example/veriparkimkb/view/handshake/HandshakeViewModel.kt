package com.example.veriparkimkb.view.handshake

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.veriparkimkb.repo.Handshake

class HandshakeViewModel(private val handshakeUseCase: Handshake) : ViewModel(){

    fun getHandshake() = liveData {
        val handshake = handshakeUseCase.execute()
        emit(handshake)
    }
}