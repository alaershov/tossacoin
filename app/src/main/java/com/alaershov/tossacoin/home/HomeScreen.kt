package com.alaershov.tossacoin.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.alaershov.tossacoin.navigation.Navigation
import com.alaershov.tossacoin.navigation.Screens
import com.github.terrakok.modo.replace

@Composable
fun HomeScreen(text: String) {
    Column {
        Text(text = "Home screen for $text")
        Button(onClick = { Navigation.modo.replace(Screens.AccountList()) }) {
            Text(text = "Go to Account List")
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
    HomeScreen("Preview")
}
