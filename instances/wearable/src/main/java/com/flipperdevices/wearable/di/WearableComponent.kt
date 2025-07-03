package com.flipperdevices.wearable.di

import com.flipperdevices.core.di.AppGraph
import com.flipperdevices.wearable.MainWearActivity
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(AppGraph::class)
interface WearableComponent {

    fun inject(activity: MainWearActivity)

}
