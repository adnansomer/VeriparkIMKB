package com.example.veriparkimkb.view.di.imkb

import com.example.veriparkimkb.view.imkbdetail.ImkbDetailFragment
import dagger.Subcomponent

@ImkbListScope
@Subcomponent(modules = [ImkbDetailModule::class])
interface ImkbDetailSubComponent {

    fun inject(imkbDetailFragment: ImkbDetailFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create():ImkbDetailSubComponent
    }
}