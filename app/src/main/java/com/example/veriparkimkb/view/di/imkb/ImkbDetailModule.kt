package com.example.veriparkimkb.view.di.imkb

import com.example.veriparkimkb.repo.ImkbDetail
import com.example.veriparkimkb.view.imkbdetail.ImkbDetailViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ImkbDetailModule {
    @ImkbDetailScope
    @Provides
    fun provideImkbDetailViewModelFactory(getImkbDetailUseCase: ImkbDetail): ImkbDetailViewModelFactory {
        return ImkbDetailViewModelFactory(getImkbDetailUseCase)
    }
}