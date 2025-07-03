package com.flipperdevices.nfceditor.sample.di

import com.flipperdevices.core.di.AppGraph
import com.flipperdevices.nfceditor.sample.NfcEditorActivity
import com.squareup.anvil.annotations.MergeComponent
import javax.inject.Singleton

@Singleton
@MergeComponent(AppGraph::class)
interface AppComponent {

    fun inject(activity: NfcEditorActivity)

}
