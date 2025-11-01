package app.yami.kmpmapdemo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
actual fun MapView(
    modifier: Modifier,
    vararg mapValues: MapValues,
    zoom: Float
) {
    val latLng: LatLng? = if (mapValues.isNotEmpty()) {
        LatLng(mapValues.first().latitude, mapValues.first().longitude)
    } else null
    val cameraPosition = rememberCameraPositionState {
        latLng?.let { position = CameraPosition.fromLatLngZoom(it, zoom) }
    }
    val mapUiSettings by remember { mutableStateOf(MapUiSettings(zoomGesturesEnabled = true)) }
    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraPosition,
        uiSettings = mapUiSettings
    ) {
        mapValues.forEach { value ->
            Marker(
                state = MarkerState(position = LatLng(value.latitude, value.longitude)),
                title = value.title,
                snippet = value.snippet
            )
        }
    }
}