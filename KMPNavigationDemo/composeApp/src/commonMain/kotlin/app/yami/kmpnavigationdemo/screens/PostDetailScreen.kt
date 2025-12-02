package app.yami.kmpnavigationdemo.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import app.yami.kmpnavigationdemo.util.Item
import app.yami.kmpnavigationdemo.widget.MyAppBar

@Composable
fun PostDetailScreen(item: Item, modifier: Modifier, backStack: SnapshotStateList<NavKey>) {
    Scaffold(topBar = {
        MyAppBar(
            title = item.title,
            isBackNeeded = true,
            backStack = backStack
        )
    }) { padding ->
        Column(modifier= modifier.padding(padding).padding(16.dp)) {
            Text(item.description)
        }

    }
}