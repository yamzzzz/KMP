package app.yami.kmpdatastore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import app.yami.kmpdatastore.screens.LoginScreen
import app.yami.kmpdatastore.storedata.DataStoreHelper
import app.yami.kmpdatastore.storedata.createDataStore
import app.yami.kmpdatastore.widget.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            val context = LocalContext.current
            val store = remember(context) { DataStoreHelper(createDataStore(context)) }
            AppNavigation(store = store)
        }
    }
}

