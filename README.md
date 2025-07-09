# Unofficial Flipper Android App - Degoogled

The build provided by F-Droid disables telemetry using flags: `is_google_feature=false is_sentry_publish=false is_metric_enabled=false`

This fork removes it from the code entirely.

Removed:
- countly
- shake2report
- metric
- gms
- firebase
