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

- display MAC address in device list
- display MAC address for device in info card header
- [WIP] toggle device filter by known flipper prefix (found in Constans.kt)
  - `DEVICENAME_PREFIX = "Flipper"`
  - `MAC_PREFIX = "80:E1:26:"`
- [TODO?] maybe try to get the firmware update to pull optionally from unleashed or monument, instead of just ofw?
  - can we just point `FapDeveloperInformation.githubRepositoryLink` to what ever we want?
