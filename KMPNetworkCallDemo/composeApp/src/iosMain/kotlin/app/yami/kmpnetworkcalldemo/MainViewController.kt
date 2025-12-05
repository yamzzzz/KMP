package app.yami.kmpnetworkcalldemo

import androidx.compose.ui.window.ComposeUIViewController
import app.yami.kmpnetworkcalldemo.network.KtorClient

fun MainViewController() = ComposeUIViewController { App(client = KtorClient()) }