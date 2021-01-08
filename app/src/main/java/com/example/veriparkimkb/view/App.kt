package com.example.veriparkimkb.view

import android.app.Application
import android.os.Build
import android.provider.Settings
import com.example.veriparkimkb.data.model.handshake.HandshakeRequest
import com.example.veriparkimkb.view.di.Injector
import com.example.veriparkimkb.view.di.core.*
import com.example.veriparkimkb.view.di.handshake.HandshakeSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule())
            .handshakeRemoteDataModule(
                HandshakeRemoteDataModule(
                    HandshakeRequest(
                        Settings.Secure.getString(
                            applicationContext.contentResolver,
                            Settings.Secure.ANDROID_ID
                        ),
                        Build.MODEL,
                        Build.MANUFACTURER,
                        if (Build.FINGERPRINT.contains("generic")) {
                            "AndroidSimulator"
                        } else {
                            "Android"
                        },
                        Build.VERSION.SDK_INT.toString()
                    )
                )
            )
            .build()
    }

    override fun createHandshakeSubComponent(): HandshakeSubComponent {
        return appComponent.handshakeSubComponent().create()
    }
}