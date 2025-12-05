package app.yami.kmpnetworkcalldemo.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import app.yami.kmpnetworkcalldemo.data.Post
import app.yami.kmpnetworkcalldemo.network.KtorClient
import app.yami.kmpnetworkcalldemo.viewmodel.PostListViewModel
import app.yami.kmpnetworkcalldemo.widget.ListItem
import app.yami.kmpnetworkcalldemo.widget.MyAppBar

@Composable
fun PostListScreen(
    client: KtorClient,
    viewModel: PostListViewModel = viewModel {
        PostListViewModel(client)
    },
    modifier: Modifier,
    onPostClick: (Post) -> Unit,
    backStack: SnapshotStateList<NavKey>
) {
    var posts by rememberSaveable { mutableStateOf(emptyList<Post>()) }
    LaunchedEffect(Unit) {
        posts = viewModel.getPosts()
    }
    Scaffold(topBar = {
        MyAppBar(
            title = "Post List Screen",
            backStack = backStack
        )
    }) { padding ->
        LazyColumn(modifier = modifier.padding(padding)) {
            items(posts) {
                Column(Modifier.fillMaxSize().clickable {
                    onPostClick(it)
                }) {
                    ListItem(it.title, it.body)
                }

            }
        }
    }
}

