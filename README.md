# MuseAi-Number-5

An Android/Kotlin app with five numbered Muse.ai WebView tabs and a separate Group tab. Each tab opens `https://muse.ai/` in a distinct named WebView profile.

**Status:** Muse.ai destinations configured · Device/runtime verification pending · No release APK

## Why this exists

If you use several Muse.ai sessions, it is easy to lose track of which workspace you are in. MuseAi-Number-5 provides five visible tabs, each loading the same Muse.ai starting URL with a stable, separate WebView profile, plus a sixth tab for Group. Sign in to the desired account independently in each tab. Separate WebView profiles keep browser data such as cookies and web storage apart where supported, but they are not a full security sandbox.

Group remains a disconnected UI scaffold, and sending is disabled. The Muse.ai pages require internet access and an Android System WebView provider that supports AndroidX WebKit multi-profile; on unsupported devices, the app displays an update message rather than silently sharing one profile.

## See it work

**Live demo:** No public demo URL could be verified, so none is linked here. A static landing page and deployment workflow are included, but no deployment has been run for this project.

**Demo GIF/video:** Unavailable. No Android emulator or device was connected for a real app recording.

The fastest real trial is to build and install the debug app on a connected Android device or emulator with a current Android System WebView and internet access. The five tabs are configured to open Muse.ai; real-device loading, sign-in, and per-profile behavior still need testing. The [manual walkthrough](testing/muse-number-five.flow.json) remains marked **NOT RUN** and the D11 release gate remains open.

## Quick start

You need JDK 17 or newer, Android SDK Platform 34, Android Build-Tools 34.0.0, and an Android device or emulator with USB debugging enabled. Update Android System WebView (or Chrome where it provides WebView) to a version supporting multi-profile WebViews. The Gradle wrapper downloads Gradle 8.7 if needed.

```sh
# Build the debug APK
./gradlew assembleDebug

# Install it on a connected Android device or emulator
adb install -r app/build/outputs/apk/debug/app-debug.apk

# Launch the debug package
adb shell monkey -p com.fedos.musenumberfive.debug 1
```

On Windows, replace `./gradlew` with `gradlew.bat`. The APK is a debug artifact, not a release build. No Android unit or instrumentation test suite is included yet. The JSON files under [`testing/`](testing/) are proposed manual scenarios, not executable test evidence; the Group scenario is read-only and never sends a message.

## Screenshots

No genuine app screenshots are available yet because no Android emulator or device was connected for capture. The files under [`promo/`](promo/) are concept illustrations, not app screens, so they are not presented as screenshots.

## What works today

- The app shell presents five tabs labeled **Muse 1** through **Muse 5**, plus a separate Group tab. Each Muse tab opens `https://muse.ai/` in its own stable named WebView profile.
- Muse WebViews enable JavaScript and DOM storage, allow HTTPS navigation in the same slot, and block other URL schemes. If the installed Android System WebView lacks multi-profile support, the slot shows an update message rather than sharing the default profile.
- Group displays a not-connected scaffold. The relay client is deliberately unconfigured, so it does not fetch or send messages.

The updated debug APK builds with Android SDK Platform 34, and the Android lint task completes with non-blocking warnings. The app has not been installed or exercised on a device here. Storage separation, lifecycle behavior, and real-device navigation still need the documented tests. Read [`docs/TESTING.md`](docs/TESTING.md) before treating any of those behaviors as verified.

## Build the static project site

The repository also includes a promotional site at `index.html`. Build its public-only output with Python 3; no third-party Python packages are required:

```sh
python3 scripts/build_site.py
```

The command writes `dist/`. It includes the two content pages, a custom 404 page, documentation, favicon, and promotional art—not the Android source tree.

To publish with GitHub Pages, push the repository to GitHub, set **Settings → Pages → GitHub Actions**, and push to `main`. The included workflow builds and deploys `dist/`. No successful Pages deployment is claimed here. Cloudflare Pages and Workers static-asset instructions are in [`docs/DEPLOYMENT.md`](docs/DEPLOYMENT.md); the Cloudflare workflow is manual and requires owner-provided credentials.

## Invite codes

### Muse

Check out Muse, your personal AI agent. Redeem my code in Settings within 48 hours of joining and we'll both get 1 billion Muse tokens.

**Code:** `5F2V31`  
[https://muse.ai/join](https://muse.ai/join)

### Manus AI

Manus Ai Invite Code: `G3ADN`

### Teamily

Join me on Teamily, the human-agent platform, where you and always-on agents get work done together in one unified and context-aware space.

Redeem my code in Settings - Credits Center and you'll get 5 CREDITS right away.

**Code:** `2U6Q8D`  
[https://teamily.ai/i/2U6Q8D](https://teamily.ai/i/2U6Q8D)

## Repository map

- `app/` — Android app source, resources, and Muse.ai WebView integration.
- `assets/` and `promo/` — editable icon/preview artwork and eight separate concept illustrations.
- `docs/` — slot decisions, build and release notes, testing, Group limits, and deployment.
- `prompts/` — the supplied authoring prompts.
- `testing/` — sample manual scenarios and an explicitly non-real sample report.
- `.github/workflows/` — Android debug-build CI and optional static-site deployment workflows.

For the slot lineup and unresolved decisions, see [`docs/SLOTS.md`](docs/SLOTS.md) and [`docs/DECISIONS.md`](docs/DECISIONS.md). The supplied core file list is in [`docs/ultimate-file-tree.md`](docs/ultimate-file-tree.md).

## Release and license

There is no release APK or Play Store listing. The local debug build is not a distributable release. The `LICENSE` file is a placeholder, not a license grant; the project owner must choose a license before distribution.
