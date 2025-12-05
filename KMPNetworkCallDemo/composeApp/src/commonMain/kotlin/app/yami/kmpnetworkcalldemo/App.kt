package app.yami.kmpnetworkcalldemo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import app.yami.kmpnetworkcalldemo.navigation.AppNavigation
import app.yami.kmpnetworkcalldemo.network.KtorClient
import io.ktor.client.HttpClient
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App(client: KtorClient) {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        AppNavigation(modifier = Modifier.fillMaxSize(), client)
    }
}