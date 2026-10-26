# MuseAi-Number-5

<img width="1280" height="696" alt="Screenshot 2026-10-26 124932" src="https://github.com/user-attachments/assets/c40ca90f-4987-41e2-9de6-51cc7ee30eea" />

An Android/Kotlin starter app with five numbered WebView slots and a separate Group tab—currently local placeholders, not connected AI agents.

**Status:** Debug build checked locally · No release APK · No verified live demo URL · D1 still open

<img width="1282" height="700" alt="Screenshot 2026-10-23 112703" src="https://github.com/user-attachments/assets/e120250b-f41c-4317-b22b-5c89356c9f04" />

## Why this exists

If you use several browser-based AI assistants, it is easy to lose track of which workspace you are in. MuseAi-Number-5 explores a single Android shell with five visible slots and a sixth tab for Group.

The project is intentionally candid about what is missing. Muse is the only named slot. Slots 2–5 are unassigned. The app opens a local placeholder in each slot; it does not connect to AI providers. Group is a disconnected UI scaffold, and sending is disabled. Separate tabs are not proof of secure storage isolation.

<img width="1279" height="703" alt="Screenshot 2026-10-26 124950" src="https://github.com/user-attachments/assets/419969a3-e876-4e23-9c1b-302a28ed8080" />

## See it work

**Live demo:** No public demo URL could be verified, so none is linked here. A static landing page and deployment workflow are included, but no deployment has been run for this project.

**Demo GIF/video:** Unavailable. No Android emulator or device was connected for a real app recording.

The fastest real trial is to build and install the debug app on an Android device or emulator. It opens the local tab shell described above. See the [slot placeholder used by the app](app/src/main/assets/slot-placeholder.html) and the [sample manual walkthrough](testing/muse-number-five.flow.json); that walkthrough is marked **NOT RUN** and D11 remains an open release gate.

<img width="1285" height="697" alt="Screenshot 2026-10-26 125014" src="https://github.com/user-attachments/assets/2211e512-e220-431a-9590-b18148eda55d" />

## Quick start

You need JDK 17 or newer, Android SDK Platform 34, Android Build-Tools 34.0.0, and an Android device or emulator with USB debugging enabled. The Gradle wrapper downloads Gradle 8.7 if needed.

```sh
# Build the debug APK
./gradlew assembleDebug

# Install it on a connected Android device or emulator
adb install -r app/build/outputs/apk/debug/app-debug.apk

# Launch the debug package
adb shell monkey -p com.fedos.musenumberfive.debug 1
```

On Windows, replace `./gradlew` with `gradlew.bat`. The APK is a debug artifact, not a release build. No Android unit or instrumentation test suite is included yet. The JSON files under [`testing/`](testing/) are proposed manual scenarios, not executable test evidence; the Group scenario is read-only and never sends a message.

<img width="1283" height="698" alt="Screenshot 2026-10-26 125004" src="https://github.com/user-attachments/assets/83432f64-1978-4dd5-a8ab-c5720e9d670e" />

## Screenshots

No genuine app screenshots are available yet because no Android emulator or device was connected for capture. The files under [`promo/`](promo/) are concept illustrations, not app screens, so they are not presented as screenshots.

## What works today

- The app shell presents five slot tabs plus a separate Group tab. Slot 1 is labeled **Muse**; slots 2–5 remain unassigned.
- Each slot opens a bundled local HTML placeholder. The WebView disables JavaScript and DOM storage. Its navigation policy keeps HTTPS navigation in that WebView and blocks other URL schemes; no remote destination is configured in the shipped starter.
- Group displays a not-connected scaffold. The relay client is deliberately unconfigured, so it does not fetch or send messages.

The debug build and launcher resources were checked, but the app was not installed or exercised on a device here. Storage separation, lifecycle behavior, and real-device navigation still need the documented tests. Read [`docs/TESTING.md`](docs/TESTING.md) before treating any of those behaviors as verified.

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

- `app/` — Android app source, resources, and local placeholder page.
- `assets/` and `promo/` — editable icon/preview artwork and eight separate concept illustrations.
- `docs/` — slot decisions, build and release notes, testing, Group limits, and deployment.
- `prompts/` — the supplied authoring prompts.
- `testing/` — sample manual scenarios and an explicitly non-real sample report.
- `.github/workflows/` — Android debug-build CI and optional static-site deployment workflows.

For the slot lineup and unresolved decisions, see [`docs/SLOTS.md`](docs/SLOTS.md) and [`docs/DECISIONS.md`](docs/DECISIONS.md). The supplied core file list is in [`docs/ultimate-file-tree.md`](docs/ultimate-file-tree.md).

## Release and license

There is no release APK or Play Store listing. The local debug build is not a distributable release. The `LICENSE` file is a placeholder, not a license grant; the project owner must choose a license before distribution.
