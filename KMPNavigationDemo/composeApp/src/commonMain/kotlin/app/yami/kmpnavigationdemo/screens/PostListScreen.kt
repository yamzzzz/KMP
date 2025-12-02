package app.yami.kmpnavigationdemo.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import app.yami.kmpnavigationdemo.util.Item
import app.yami.kmpnavigationdemo.util.listItems
import app.yami.kmpnavigationdemo.widget.ListItem
import app.yami.kmpnavigationdemo.widget.MyAppBar

@Composable
fun PostListScreen(modifier: Modifier, onPostClick: (Item)->Unit, backStack: SnapshotStateList<NavKey>) {
    Scaffold(topBar = {
        MyAppBar(
            title = "Post List Screen",
            backStack = backStack
        )
    }) { padding ->
        LazyColumn(modifier = modifier.padding(padding)) {
            items(listItems) {
                Column(Modifier.fillMaxSize().clickable {
                    onPostClick(it)
                }) {
                    ListItem(it.title, it.description)
                }

            }
        }
    }
}