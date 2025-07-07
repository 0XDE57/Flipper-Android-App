plugins {
    id("flipper.android-lib")
    id("flipper.anvil")
}

android.namespace = "com.flipperdevices.wearable.sync.handheld.impl"

dependencies {
    implementation(projects.components.wearable.sync.common)
    implementation(projects.components.wearable.sync.handheld.api)

    implementation(projects.components.core.di)
    implementation(projects.components.core.ktx)
    implementation(projects.components.core.log)

    implementation(projects.components.bridge.dao.api)

    implementation(libs.kotlin.coroutines)
}
