package app.yami.kmpmapdemo

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


data class MapValues(
    val title: String,
    val snippet: String,
    val latitude: Double,
    val longitude: Double
)

@Composable
expect fun MapView(
    modifier: Modifier,
    vararg mapValues: MapValues,
    zoom: Float = 10f
)