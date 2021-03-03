package com.alaershov.tossacoin.navigation

import android.app.Application
import com.alaershov.tossacoin.BuildConfig
import com.github.terrakok.modo.AppReducer
import com.github.terrakok.modo.LogReducer
import com.github.terrakok.modo.Modo
import com.github.terrakok.modo.NavigationReducer

object Navigation {

    private lateinit var _modo: Modo

    val modo: Modo
        get() = _modo

    fun init(app: Application) {
        _modo = Modo(reducer(app))
    }

    private fun reducer(app: Application): NavigationReducer {
        return if (BuildConfig.DEBUG) {
            LogReducer(AppReducer(app))
        } else {
            AppReducer(app)
        }
    }
}
