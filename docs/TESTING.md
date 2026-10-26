# Testing approach and evidence status

The JSON files in `testing/` are proposed manual scenarios, not execution records. **No flow is claimed to have been run on a device.** The D11 release gate remains open until the owner supplies acceptance criteria and evidence is recorded.

## Muse.ai slot flow and D11 gate

Test on a non-production build and a device with internet access. Confirm the installed Android System WebView version supports AndroidX WebKit multi-profile. Do not use real credentials during initial smoke tests; if testing sign-in or session separation later, use approved test accounts.

For each Muse tab, verify the initial `https://muse.ai/` page loads, JavaScript-driven content appears, and HTTPS redirects remain inside the selected tab. Verify a network failure produces the retry message. On a provider without the multi-profile feature, verify that the app displays the update message and does not silently load slots in the shared default profile.

On supported devices, sign in with controlled test accounts only if authorized, then check that cookies and web storage remain isolated among `muse-slot-1` through `muse-slot-5`. Also test tab switching, activity recreation, process restart, logout, cookies, local storage, service workers, backup/export behavior, redirects, and any required popup or file-upload flow. Separate profiles are a browsing-data boundary, not proof of complete security isolation.

D11's detailed acceptance criteria were not supplied. Do not mark the gate passed until the owner provides criteria and a real run records exact device/build/WebView versions and evidence.

## Group scenario

`muse-number-five-group.flow.json` is read-only. It checks the not-connected state, configured polling at 60 seconds, placeholder config handling, and display of received fixture data. It **must never send**: do not add a send action, transmit test text, or treat relay examples as permission to post. Use only a controlled, read-only test source if a real endpoint is later configured.

## Build and review checks

- Parse JSON fixtures and validate Android XML/Gradle structure.
- Run `./gradlew :app:assembleDebug` with Android SDK Platform 34 and Build-Tools 34.0.0 configured; run available unit/UI checks.
- Install and launch the built app on representative devices; verify five URLs, per-slot mapping, and correct Group tab index 5.
- Try HTTP and external-app schemes such as `intent:`, `tel:`, and `mailto:`; verify they do not launch another app.
- Review WebView profile persistence, network behavior, backup/export, logs, and cross-slot leakage on representative supported provider versions.
- Record failures and unresolved criteria rather than rewriting a sample report as a pass.

No release signing, release-signed APK, independent security review, real-device navigation/profile test, Group relay connection, or live deployment is evidenced by these documents.
