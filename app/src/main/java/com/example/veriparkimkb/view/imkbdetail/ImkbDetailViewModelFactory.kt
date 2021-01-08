package com.example.veriparkimkb.view.imkbdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.veriparkimkb.repo.ImkbDetail

class ImkbDetailViewModelFactory (private val getImkbDetailUseCase: ImkbDetail):
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ImkbDetailViewModel(getImkbDetailUseCase) as T
    }
}