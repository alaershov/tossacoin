package com.alaershov.tossacoin.account_list

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alaershov.tossacoin.navigation.Navigation
import com.alaershov.tossacoin.navigation.Screens
import com.github.terrakok.modo.replace

@Composable
fun AccountListScreen(text: String) {
    Column {
        Text("Account List screen for $text")
        Button(onClick = { Navigation.modo.replace(Screens.Home()) }) {
            Text("Go to Home")
        }
    }
}

@Preview
@Composable
private fun Preview() {
    AccountListScreen("Preview")
}
