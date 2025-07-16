package com.flipperdevices.firstpair.impl.composable.searching

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.flipperdevices.bridge.api.scanner.DiscoveredBluetoothDevice
import com.flipperdevices.core.ui.theme.LocalPallet
import com.flipperdevices.firstpair.impl.R
import com.flipperdevices.firstpair.impl.composable.common.ComposableSearchingAppBar
import com.flipperdevices.firstpair.impl.model.SearchingContent
import com.flipperdevices.firstpair.impl.model.SearchingState

@Composable
fun ComposableSearchingScreen(
    state: SearchingState,
    onBack: () -> Unit,
    onHelpClicking: () -> Unit,
    onSkipConnection: () -> Unit,
    onDeviceClick: (DiscoveredBluetoothDevice, resetPair: Boolean) -> Unit,
    onRefreshSearching: () -> Unit,
    onResetTimeoutState: () -> Unit,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    var isFilterChecked by remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .background(LocalPallet.current.background)
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ComposableSearchingAppBar(stringResource(R.string.firstpair_search_title), onBack)
        ComposableSearchingStatus(state, onHelpClicking)
        ComposableFilterToggle(isFilterChecked, onCheckedChange, modifier)
        ComposableSearchingContent(
            modifier = Modifier.weight(weight = 1f),
            content = state.content,
            onDeviceClick = onDeviceClick,
            onRefreshSearching = onRefreshSearching,
            onResetTimeoutState = onResetTimeoutState
        )
        ComposableSearchingFooter(onSkipConnection)
    }
}

@Composable
fun ComposableFilterToggle(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.padding(
            end = 8.dp,
            top = 8.dp,
            bottom = 8.dp,
            start = 18.dp
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = modifier,
            text = "Filter: ",
            textAlign = TextAlign.Left
        )
        Switch(
            checked = isChecked,
            //onCheckedChange = onCheckedChange,
            onCheckedChange = { newValue ->
                isChecked = newValue
            },
            modifier = modifier
        )
    }
}

@Composable
fun ComposableSearchingContent(
    content: SearchingContent,
    onDeviceClick: (DiscoveredBluetoothDevice, resetPair: Boolean) -> Unit,
    onRefreshSearching: () -> Unit,
    onResetTimeoutState: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (content) {
        is SearchingContent.Finished -> Text(
            modifier = modifier.fillMaxWidth(),
            text = stringResource(R.string.firstpair_search_title),
            textAlign = TextAlign.Center
        )

        is SearchingContent.FoundedDevices -> ComposableSearchingDevices(
            modifier = modifier,
            state = content,
            onDeviceClick = onDeviceClick,
            onRefreshSearching = onRefreshSearching,
            onResetTimeoutState = onResetTimeoutState
        )

        is SearchingContent.PermissionRequest -> ComposablePermissionRequest(
            modifier = modifier,
            state = content
        )

        SearchingContent.Searching -> ComposableSearchingProgress(modifier)
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
private fun ComposableSearchingScreenPreview() {
    ComposableSearchingScreen(
        SearchingState(
            showSearching = true,
            showHelp = true,
            content = SearchingContent.Searching
        ),
        onBack = {},
        onHelpClicking = {},
        onSkipConnection = {},
        onRefreshSearching = {},
        onDeviceClick = { _, _ -> },
        onResetTimeoutState = {},
        onCheckedChange = {}
    )
}
