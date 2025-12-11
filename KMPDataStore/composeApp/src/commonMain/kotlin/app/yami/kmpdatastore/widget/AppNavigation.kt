package app.yami.kmpdatastore.widget

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
import app.yami.kmpdatastore.PreferencesKeys
import app.yami.kmpdatastore.screens.HomeScreen
import app.yami.kmpdatastore.screens.LoginScreen
import app.yami.kmpdatastore.storedata.DataStoreHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


data object LoginScreen : NavKey
data object HomeScreen : NavKey

@Composable
fun AppNavigation(store: DataStoreHelper) {
    val backStack = remember { mutableStateListOf(LoginScreen as NavKey) }
    val scope = rememberCoroutineScope()
    var userName by rememberSaveable { mutableStateOf("") }
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is LoginScreen -> NavEntry(key) {
                    scope.launch { userName = store.getValue(PreferencesKeys.USERNAME) }
                    if (userName.isNotEmpty()) {
                        CallHomeScreen(userName, scope, store, backStack)
                    } else {
                        LoginScreen(store = store, backStack = backStack)
                    }
                }

                is HomeScreen -> NavEntry(key) {
                    scope.launch { userName = store.getValue(PreferencesKeys.USERNAME) }
                    CallHomeScreen(userName, scope, store, backStack)
                }

                else -> throw RuntimeException("Invalid NavKey!")
            }
        }
    )
}

@Composable
private fun CallHomeScreen(
    userName: String,
    scope: CoroutineScope,
    store: DataStoreHelper,
    backStack: SnapshotStateList<NavKey>
) {
    HomeScreen(userName, action = {
        scope.launch { store.clear() }
        backStack.clear()
        backStack.add(LoginScreen)
    })
}
