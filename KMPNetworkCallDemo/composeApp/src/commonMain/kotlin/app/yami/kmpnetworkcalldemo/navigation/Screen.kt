package app.yami.kmpnetworkcalldemo.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable
@Serializable
data object PostList: NavKey
@Serializable
data class PostDetail(val id: Int): NavKey