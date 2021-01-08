package com.example.veriparkimkb.view.imkbdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.veriparkimkb.repo.ImkbDetail

class ImkbDetailViewModel (private val getImkbDetailUseCase: ImkbDetail) : ViewModel() {

    fun getImkbDetail() = liveData {
        val imkbDetail = getImkbDetailUseCase.execute()
        emit(imkbDetail)
    }
}