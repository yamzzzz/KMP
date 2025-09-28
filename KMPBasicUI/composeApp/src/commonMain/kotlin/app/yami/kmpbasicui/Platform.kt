package app.yami.kmpbasicui

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform