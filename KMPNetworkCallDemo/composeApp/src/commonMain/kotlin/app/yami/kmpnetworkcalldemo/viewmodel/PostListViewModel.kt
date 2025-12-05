package app.yami.kmpnetworkcalldemo.viewmodel

import androidx.lifecycle.ViewModel
import app.yami.kmpnetworkcalldemo.data.Post
import app.yami.kmpnetworkcalldemo.network.KtorClient
import io.ktor.client.HttpClient

class PostListViewModel(private val client: KtorClient): ViewModel() {

    suspend fun getPosts(): List<Post> = client.getPosts()
}