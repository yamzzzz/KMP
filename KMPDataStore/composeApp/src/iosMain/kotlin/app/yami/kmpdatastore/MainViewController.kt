package app.yami.kmpdatastore

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import app.yami.kmpdatastore.screens.LoginScreen
import app.yami.kmpdatastore.storedata.DataStoreHelper
import app.yami.kmpdatastore.storedata.IosDataStore
import app.yami.kmpdatastore.storedata.createDataStore
import app.yami.kmpdatastore.widget.AppNavigation

fun MainViewController() = ComposeUIViewController {
    val dataStore = remember { DataStoreHelper(IosDataStore.getCreateDataStore()) }
    AppNavigation(store = dataStore)
}

