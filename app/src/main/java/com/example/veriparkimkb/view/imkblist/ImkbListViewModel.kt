package com.example.veriparkimkb.view.imkblist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.veriparkimkb.data.model.imkb.ListRequest
import com.example.veriparkimkb.data.model.imkb.ListResponse
import com.example.veriparkimkb.repo.ImkbList
import com.example.veriparkimkb.view.di.core.NetModule
import retrofit2.Response

class ImkbListViewModel() : ViewModel() {
    lateinit var getImkbListUseCase: ImkbList

    fun getImkbList(auth:String,request: ListRequest) = liveData {
        val imkbList: Response<ListResponse> = NetModule().provideImkbService().requestList(auth,request)
        emit(imkbList)
    }
}