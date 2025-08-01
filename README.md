# Unofficial Flipper Android App - Degoogled

The build provided by F-Droid disables telemetry using flags: 
- `is_google_feature=false`
- `is_sentry_publish=false`
- `is_metric_enabled=false`

This fork removes these dependencies from the code entirely, and adds a couple minor features.

Removed:
- countly
- shake2report
- metric
- gms
- firebase


# Features
- display rssi in device list
- display MAC address in device list
- display MAC address for device in info card header
- toggle device filter by known flipper prefix (found in Constans.kt)
  - `DEVICENAME_PREFIX = "Flipper"`
  - `MAC_PREFIX = "80:E1:26:"`
  - > Last 3 octets of BLE address are always fixed.
    > 4th octet of p/x furi_hal_version.ble_mac will be 0x26 on flippers manufactured in 2023+
    > - #3723
- [TODO?] maybe try to get the firmware update to pull optionally from unleashed or monument, instead of just ofw?
