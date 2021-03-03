package com.alaershov.tossacoin.navigation.compose

import android.app.Activity
import android.util.Log
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.github.terrakok.modo.NavigationRender
import com.github.terrakok.modo.NavigationState
import com.github.terrakok.modo.Screen

class ComposeRender(
    private val exitAction: () -> Unit
) : NavigationRender {

    constructor(
        activity: Activity,
    ) : this(exitAction = { activity.finish() })

    var state: NavigationState by mutableStateOf(NavigationState())
        private set

    override fun invoke(state: NavigationState) {
        Log.d("Modo", "invoke ComposeRender with $state")
        this.state = state
        if (state.chain.isEmpty()) {
            Log.d("Modo", "invoke ComposeRender exit action, chain is empty")
            exitAction.invoke()
        }
    }
}

@Composable
fun NavigationStateRender(render: ComposeRender) {
    render.state.chain.lastOrNull()?.let { ScreenRender(it) }
}

@Composable
fun ScreenRender(screen: Screen) {
    when (screen) {
        is ComposeScreen -> screen.content.invoke()
        else -> Text(text = "ComposeRender works with AppScreens only! Received $screen")
    }
}
