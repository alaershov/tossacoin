package com.alaershov.tossacoin.navigation.compose

import android.util.Log
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.terrakok.modo.NavigationRender
import com.github.terrakok.modo.NavigationState
import com.github.terrakok.modo.Screen

class ComposeRender : NavigationRender {

    private val _state = MutableLiveData<NavigationState>()
    val state: LiveData<NavigationState>
        get() = _state

    override fun invoke(state: NavigationState) {
        _state.value = state
        Log.d("Modo", "invoke ComposeRender with $state")
    }
}

@Composable
fun NavigationStateRender(render: ComposeRender) {
    val navigationState: NavigationState by render.state.observeAsState(NavigationState())
    navigationState.chain.lastOrNull()?.let { ScreenRender(it) }
}

@Composable
fun ScreenRender(screen: Screen) {
    when (screen) {
        is ComposeScreen -> screen.content.invoke()
        else -> Text(text = "ComposeRender works with AppScreens only! Received $screen")
    }
}
