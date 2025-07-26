package com.flipperdevices.info.impl.model

sealed class DeviceStatus {
    object NoDevice : DeviceStatus()
    data class NoDeviceInformation(
        val deviceName: String,
        val connectInProgress: Boolean
    ) : DeviceStatus()

    data class Connected(
        val deviceName: String,
        val deviceMac: String,
        val batteryLevel: Float,
        val isCharging: Boolean
    ) : DeviceStatus()

    fun getFlipperName(): String = when (this) {
        is Connected -> deviceName
        NoDevice -> ""
        is NoDeviceInformation -> deviceName
    }
/* ^ only used by forgot. not by header
    fun getFlipperMac(): String = when (this) {
        is Connected -> deviceMac
        NoDevice -> ""
        is NoDeviceInformation -> deviceName
    }*/

}
