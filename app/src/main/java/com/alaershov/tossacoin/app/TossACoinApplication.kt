package com.alaershov.tossacoin.app

import android.app.Application
import com.alaershov.tossacoin.navigation.Navigation

class TossACoinApplication : Application() {

    override fun onCreate() {
        Navigation.init(this)
        super.onCreate()
    }
}
