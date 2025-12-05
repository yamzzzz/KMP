package app.yami.kmpnetworkcalldemo.network

import app.yami.kmpnetworkcalldemo.data.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class PostAPIImpl(private val client: HttpClient) : APIInterface{
    override suspend fun getPosts(): List<Post> {
        return client.get("/posts").body()
    }

}
