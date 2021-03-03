package com.alaershov.tossacoin.navigation

import com.alaershov.tossacoin.account_list.AccountListScreen
import com.alaershov.tossacoin.home.HomeScreen
import com.alaershov.tossacoin.navigation.compose.ComposeScreen

object Screens {

    fun Home() = ComposeScreen("HomeScreen") {
        HomeScreen("Modo")
    }

    fun AccountList() = ComposeScreen("AccountListScreen") {
        AccountListScreen("Modo")
    }
}
