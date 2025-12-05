package app.yami.kmpnetworkcalldemo.widget

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation3.runtime.NavKey


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(
    title: String?,
    isBackNeeded: Boolean? = null,
    backStack: SnapshotStateList<NavKey>
) {
    TopAppBar(title = { Text(text = title?: "", maxLines = 1, overflow = TextOverflow.Ellipsis) },
        navigationIcon = {
            if (isBackNeeded == true) {
                IconButton(onClick = { backStack.removeLastOrNull()}) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior())
}