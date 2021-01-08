package com.example.veriparkimkb.view.di.core

import com.example.veriparkimkb.data.api.HandshakeService
import com.example.veriparkimkb.data.api.ImkbService
import com.example.veriparkimkb.util.Constant.getBaseUrl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()
        return Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideImkbService(): ImkbService {
        return provideRetrofit().create(ImkbService::class.java)
    }

    @Singleton
    @Provides
    fun provideHandshakeService():HandshakeService{
        return provideRetrofit().create(HandshakeService::class.java)
    }
}