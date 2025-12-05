package app.yami.kmpnetworkcalldemo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
import app.yami.kmpnetworkcalldemo.screens.PostDetailScreen
import app.yami.kmpnetworkcalldemo.screens.PostListScreen
import app.yami.kmpnetworkcalldemo.data.Post
import app.yami.kmpnetworkcalldemo.network.KtorClient
import io.ktor.client.HttpClient

data object ListScreen : NavKey
data class DetailScreen(val post: Post) : NavKey

@Composable
fun AppNavigation(modifier: Modifier, client: KtorClient) {
    val backStack = remember { mutableStateListOf(ListScreen as NavKey) }
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is ListScreen -> NavEntry(key) {
                    PostListScreen(client = client, modifier = modifier, onPostClick = { item ->
                        backStack.add(DetailScreen(post = item))
                    }, backStack = backStack)
                }

                is DetailScreen -> NavEntry(key) {
                    PostDetailScreen(post = key.post, modifier, backStack)

                }

                else -> throw RuntimeException("Invalid NavKey!")
            }
        }
    )
}