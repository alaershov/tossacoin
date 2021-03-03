package com.alaershov.tossacoin.navigation.compose

import androidx.compose.runtime.Composable
import com.github.terrakok.modo.Screen

class ComposeScreen(
    override val id: String,
    val content: @Composable () -> Unit
) : Screen
