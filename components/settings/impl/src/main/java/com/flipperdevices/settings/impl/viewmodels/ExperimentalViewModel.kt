package com.flipperdevices.settings.impl.viewmodels

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pushToFront
import com.flipperdevices.core.di.provideDelegate
import com.flipperdevices.core.ui.lifecycle.DecomposeViewModel
import com.flipperdevices.settings.impl.model.SettingsNavigationConfig
import javax.inject.Inject
import javax.inject.Provider

class ExperimentalViewModel @Inject constructor(
) : DecomposeViewModel() {

    fun onOpenFileManager(navigation: StackNavigation<SettingsNavigationConfig>) {
        navigation.pushToFront(SettingsNavigationConfig.FileManager)
    }
}
