package app.yami.kmpdatastore.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import app.yami.kmpdatastore.PreferencesKeys
import app.yami.kmpdatastore.storedata.DataStoreHelper
import app.yami.kmpdatastore.widget.HomeScreen
import app.yami.kmpdatastore.widget.MyAppBar
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun LoginScreen(store: DataStoreHelper, backStack: SnapshotStateList<NavKey>) {

    val scope = rememberCoroutineScope()
    var userName by rememberSaveable { mutableStateOf("") }
    Scaffold(topBar = {
        MyAppBar(
            title = "Login"
        )
    }) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                label = { Text("Enter UserName") },
                value = userName, onValueChange = { userName = it },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            )
            Spacer(Modifier.height(30.dp))

            Button(onClick = {
                scope.launch { store.save(PreferencesKeys.USERNAME, userName) }
                backStack.add(HomeScreen)
            }) {
                Text("Login")
            }

        }

    }
}