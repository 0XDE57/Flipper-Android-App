package com.flipperdevices.app.di

import com.flipperdevices.bridge.connection.service.api.FConnectionService
import com.flipperdevices.bridge.synchronization.api.SynchronizationApi
import com.flipperdevices.core.di.AppGraph
import com.flipperdevices.core.permission.impl.PermissionRequestHandlerImpl
import com.flipperdevices.notification.api.FlipperAppNotificationApi
import com.squareup.anvil.annotations.ContributesTo
import javax.inject.Provider

@ContributesTo(AppGraph::class)
interface MainComponent {
    val synchronizationApi: Provider<SynchronizationApi>
    val notificationApi: Provider<FlipperAppNotificationApi>
    val permissionRequestHandlerImpl: Provider<PermissionRequestHandlerImpl>
    val fConnectionService: Provider<FConnectionService>
}
