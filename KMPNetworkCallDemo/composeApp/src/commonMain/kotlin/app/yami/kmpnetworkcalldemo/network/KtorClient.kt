package app.yami.kmpnetworkcalldemo.network

import app.yami.kmpnetworkcalldemo.data.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class KtorClient {
    private fun getClient(): HttpClient {
        return HttpClient {

            install(DefaultRequest) {
                url {
                    host = "jsonplaceholder.typicode.com"
                    protocol = URLProtocol.HTTPS
                    contentType(ContentType.Application.Json)
                }
            }

            install(ContentNegotiation) {
                json(json = Json {
                    ignoreUnknownKeys = true
                })
            }

            install(HttpTimeout) {
                socketTimeoutMillis = 15_000
                connectTimeoutMillis = 15_000
                requestTimeoutMillis = 15_000
            }

            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.BODY
            }
        }
    }

    suspend fun getPosts(): List<Post> {
        return getClient().get("/posts").body<List<Post>>()
    }
}