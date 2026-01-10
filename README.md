# Unofficial Flipper Android App - Degoogled & Privacy Enhanced


The official flipper app collects data about your device. From: https://cdn.flipperzero.one/privacy-policy.html
>Mobile Device Data. We automatically collect device information (such as your mobile device ID, model, and manufacturer), operating system, version information and system configuration information, device and application identification numbers, browser type and version, hardware model Internet service provider and/or mobile carrier, and Internet Protocol (IP) address (or proxy server). If you are using our application(s), we may also collect information about the phone network associated with your mobile device, your mobile deviceâ€™s operating system or platform, the type of mobile device you use, your mobile deviceâ€™s unique device ID, and information about the features of our application(s) you accessed.


The build provided on F-Droid disables telemetry using flags: 
- `is_google_feature=false`
- `is_sentry_publish=false`
- `is_metric_enabled=false`

>2025-07-05 04:26:47,673 DEBUG: > `/home/vagrant/fdroidserver/gradlew-fdroid -Pis_google_feature=false -Pis_sentry_publish=false -Pis_metric_enabled=false clean`

Source: https://f-droid.org/repo/com.flipperdevices.app_1878.log.gz

**This privacy enhanced fork ensures nothing is collected by removing these dependencies from the code entirely, and adds a couple minor features.**

Removed:
- countly
- shake2report
- metric
- gms
- firebase


# Features
- display rssi in device search list on connect
- display MAC address in device search list on connect
- display MAC address for connected device in info card header
- show full device name (do not remove "Flipper" prefix when showing device names)
- toggle filter in device search list by known flipper prefix (found in `Constans.kt`). This is useful if you change or randomize your Flipper's MAC.
  - `DEVICENAME_PREFIX = "Flipper"`
  - `MAC_PREFIX = "80:E1:26:"`
  - > Last 3 octets of BLE address are always fixed.
    > 4th octet of p/x furi_hal_version.ble_mac will be 0x26 on flippers manufactured in 2023+
    > - #3723
- disable `android:autoVerify` property calling `https://*/.well-known/assetlinks.json`, which sends android build and version in user-agent.
  - https://developer.android.com/training/app-links/verify-applinks
- [TODO?] maybe try to get the firmware update to pull optionally from unleashed or monument, instead of just ofw?
