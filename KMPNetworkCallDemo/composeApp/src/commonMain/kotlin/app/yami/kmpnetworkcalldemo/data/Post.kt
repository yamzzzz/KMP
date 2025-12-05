package app.yami.kmpnetworkcalldemo.data

import kotlinx.serialization.Serializable

@Serializable
data class Post(val id: Int, val title: String? =null, val body: String?=null)