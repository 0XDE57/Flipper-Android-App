package com.flipperdevices.bridge.connection.feature.rpcstats.impl.api

import com.flipperdevices.bridge.connection.feature.getinfo.api.FGetInfoFeatureApi
import com.flipperdevices.bridge.connection.feature.rpcstats.api.FRpcStatsOnDeviceReadyFeatureApi
import com.flipperdevices.bridge.connection.feature.storageinfo.api.FStorageInfoFeatureApi
import com.flipperdevices.core.log.LogTagProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.launch

class FRpcStatsOnDeviceReadyFeatureApiImpl @AssistedInject constructor(
    @Assisted private val scope: CoroutineScope,
    @Assisted private val storageFeatureApi: FStorageInfoFeatureApi,
    @Assisted private val getInfoFeatureApiNullable: FGetInfoFeatureApi?
) : FRpcStatsOnDeviceReadyFeatureApi, LogTagProvider {
    override val TAG = "FlipperRpcStatsCollector"

    private var statJob: Job? = null

    override suspend fun onReady() {
        storageFeatureApi.invalidate(
            scope,
            force = false
        )

        val oldJob = statJob
        statJob = scope.launch {
            oldJob?.cancelAndJoin()
        }
    }



    @AssistedFactory
    fun interface InternalFactory {
        operator fun invoke(
            scope: CoroutineScope,
            storageFeatureApi: FStorageInfoFeatureApi,
            getInfoFeatureApiNullable: FGetInfoFeatureApi?
        ): FRpcStatsOnDeviceReadyFeatureApiImpl
    }
}
