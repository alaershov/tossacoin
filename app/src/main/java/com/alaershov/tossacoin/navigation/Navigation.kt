package com.alaershov.tossacoin.navigation

import android.app.Application
import com.github.terrakok.modo.AppReducer
import com.github.terrakok.modo.Modo

object Navigation {

    private lateinit var _modo: Modo

    val modo: Modo
        get() = _modo

    fun init(app: Application) {
        _modo = Modo(AppReducer(app))
    }
}
