package app.yami.kmpnetworkcalldemo.network

import app.yami.kmpnetworkcalldemo.data.Post

interface APIInterface {
    suspend fun getPosts(): List<Post>
}
