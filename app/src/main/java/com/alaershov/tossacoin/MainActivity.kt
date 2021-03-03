package com.alaershov.tossacoin

import android.os.Bundle
import androidx.activity.addCallback
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.alaershov.tossacoin.home.HomeScreen
import com.alaershov.tossacoin.navigation.Navigation
import com.alaershov.tossacoin.navigation.Screens
import com.alaershov.tossacoin.navigation.compose.ComposeRender
import com.alaershov.tossacoin.navigation.compose.NavigationStateRender
import com.alaershov.tossacoin.navigation.compose.init
import com.alaershov.tossacoin.ui.theme.TossACoinTheme
import com.github.terrakok.modo.back

class MainActivity : AppCompatActivity() {

    private val modo = Navigation.modo

    private val render = ComposeRender(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TossACoinApp {
                NavigationStateRender(render)
            }
        }

        modo.init(savedInstanceState, render, Screens.Home())
        modo.render = render

        onBackPressedDispatcher.addCallback(owner = this) {
            modo.back()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        modo.render = null
    }
}

@Composable
private fun TossACoinApp(content: @Composable () -> Unit) {
    TossACoinTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4
)
@Composable
private fun Preview() {
    TossACoinApp {
        HomeScreen("Preview")
    }
}
