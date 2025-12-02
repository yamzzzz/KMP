package app.yami.kmpnavigationdemo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
import app.yami.kmpnavigationdemo.screens.PostDetailScreen
import app.yami.kmpnavigationdemo.screens.PostListScreen
import app.yami.kmpnavigationdemo.util.Item

data object ListScreen : NavKey
data class DetailScreen(val item: Item) : NavKey

@Composable
fun AppNavigation(modifier: Modifier) {
    val backStack = remember { mutableStateListOf(ListScreen as NavKey) }
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is ListScreen -> NavEntry(key) {
                    PostListScreen(modifier, onPostClick = { item ->
                        backStack.add(DetailScreen(item = item))
                    }, backStack = backStack)
                }

                is DetailScreen -> NavEntry(key) {
                    PostDetailScreen(item = key.item, modifier, backStack)

                }

                else -> throw RuntimeException("Invalid NavKey!")
            }
        }
    )
}