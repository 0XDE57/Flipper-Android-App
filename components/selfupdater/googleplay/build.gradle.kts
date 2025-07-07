plugins {
    id("flipper.android-lib")
    id("flipper.anvil")
}

android.namespace = "com.flipperdevices.selfupdater.source.googleplay"

dependencies {
    implementation(projects.components.selfupdater.api)
    implementation(projects.components.inappnotification.api)

    implementation(projects.components.core.log)
    implementation(projects.components.core.activityholder)

    // Dagger deps
    implementation(projects.components.core.di)
}
