package com.flipperdevices.updater.card.viewmodel

import com.flipperdevices.core.ui.lifecycle.DecomposeViewModel
import com.flipperdevices.updater.api.UpdateStateApi
import com.flipperdevices.updater.api.UpdaterApi
import com.flipperdevices.updater.model.FlipperUpdateState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class UpdateStateViewModel @Inject constructor(
    private val updaterApi: UpdaterApi,
    private val updateStateApi: UpdateStateApi
) : DecomposeViewModel() {
    private val flipperStateFlow = updateStateApi.getFlipperUpdateState(viewModelScope)
        .stateIn(viewModelScope, SharingStarted.Eagerly, FlipperUpdateState.NotConnected)

    init {
        updaterApi.getState().onEach {
            /*
            val updateRequest = it.request
            val endStatus = when (it.state) {
                UpdatingState.Complete -> UpdateStatus.COMPLETED
                UpdatingState.Failed -> UpdateStatus.FAILED
                else -> null
            }
            if (endStatus != null && updateRequest != null) {
                metricApi.reportComplexEvent(
                    UpdateFlipperEnd(
                        updateFrom = updateRequest.updateFrom.version,
                        updateTo = updateRequest.updateTo.version,
                        updateId = updateRequest.requestId,
                        updateStatus = endStatus
                    )
                )
            }*/
        }.launchIn(viewModelScope)
    }

    fun getUpdateState(): StateFlow<FlipperUpdateState> = flipperStateFlow

    fun onDismissUpdateDialog() {
        updaterApi.resetState()
    }
}

//taken from: .../metric/api/events/complex/UpdateFlipperEnd.kt
enum class UpdateStatus(val id: Int) {
    COMPLETED(id = 1),
    CANCELED(id = 2),
    FAILED_DOWNLOAD(id = 3),
    FAILED_PREPARE(id = 4),
    FAILED_UPLOAD(id = 5),
    FAILED(id = 6)
}
