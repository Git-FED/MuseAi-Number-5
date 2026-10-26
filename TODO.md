# MuseAi-Number-5 — Delivery Checklist

Each item describes a deliverable from the approved plan. Items remain open until the files exist and the stated outcome is evidenced.

## 1. The repository contains the complete 73-file supplied core tree

- [x] Create the root files `README.md`, `LICENSE`, `.gitignore`, `CHANGELOG.md`, `settings.gradle.kts`, `build.gradle.kts`, `gradle.properties`, `gradlew`, `gradlew.bat`, `keystore.properties.example`, and `index.html`.
- [x] Create `gradle/wrapper/gradle-wrapper.jar` and `gradle/wrapper/gradle-wrapper.properties`, plus `.github/workflows/build.yml`.
- [x] Create `app/build.gradle.kts`, `app/proguard-rules.pro`, and `app/src/main/AndroidManifest.xml`.
- [x] Under `app/src/main/assets/`, create `slot-placeholder.html` and `group-relay-config.example.json`.
- [x] Under `app/src/main/java/com/fedos/musenumberfive/`, create `MainActivity.kt`, `Slots.kt`, `SlotManager.kt`, `MultiProfile.kt`, `GroupTab.kt`, `GroupRelayClient.kt`, `GroupMessage.kt`, and `GroupChatFragment.kt`.
- [x] Under `app/src/main/res/layout/`, create `activity_main.xml`, `fragment_group_chat.xml`, and `item_group_message.xml`; under `values/`, create `strings.xml` and `themes.xml`; under `xml/`, create `backup_rules.xml` and `data_extraction_rules.xml`; under `drawable/`, create `ic_launcher_foreground.xml` and `ic_launcher_background.xml`; under `mipmap-anydpi-v26/`, create `ic_launcher.xml` and `ic_launcher_round.xml`; and under each of `mipmap-mdpi/`, `mipmap-hdpi/`, `mipmap-xhdpi/`, `mipmap-xxhdpi/`, and `mipmap-xxxhdpi/`, create `ic_launcher.png` and `ic_launcher_round.png`.
- [x] Under root `assets/`, create editable `icon-source.svg`, `icon.png`, and `og-image.png`.
- [x] Under `promo/`, create eight separate PNGs: `01-five-in-one.png`, `02-top-5-agents.png`, `03-perfectly-simple.png`, `04-always-active.png`, `05-no-contamination.png`, `06-separate-worlds.png`, `07-under-construction.png`, and `08-muse-5-mascot.png`.
- [x] Under `docs/`, create `ultimate-file-tree.md`, `DECISIONS.md`, `SLOTS.md`, `BUILDING.md`, `TESTING.md`, and `GROUP-CHAT.md`.
- [x] Under `prompts/`, create `BUILD-PROMPT.md`, `ICON-PROMPT.md`, `PAGE-PROMPT.md`, `README-PROMPT.md`, and `PROMO-CODES-PROMPT.md`.
- [x] Under `testing/`, create `muse-number-five.flow.json`, `muse-number-five-group.flow.json`, and `sample-report.md`. The supplied contract counts these paths as 73 files. Verified all 73 required paths are present; JSON and Android XML parse.

## 2. The Android starter accurately expresses the five-slot plus Group concept

- [x] Define five slots in a single data-first `Slots.kt`; Muse/slot 1 is named, and slots 2–5 remain explicitly unassigned while D1 is open.
- [x] Provide the named activity, slot manager, profile/vault, tab, message, relay, and Group screen source files with readable responsibilities and the six-tab contract; avoid inventing agent/provider names or tokens.
- [x] Configure a single declared internet permission, HTTPS-only network policy (`cleartextTrafficPermitted=false`), Android backup exclusions for sensitive slot/relay state, and appropriate Android resources. Clearly document any privacy/isolation behavior that needs device-level verification rather than claiming it is proven.
- [x] Store only example relay configuration with placeholders. No real API keys, keystores, signing passwords, or credentials are included.
- [x] Supply Gradle wrapper/build configuration and GitHub Actions debug-build CI with release signing available only by explicit manual setup; signing secrets never enter the repository. Gradle project configuration was checked with `:app:tasks`; the debug APK was built and its signature verified. No Android device was connected, so device runtime testing remains unverified.

## 3. The static landing page works on GitHub Pages and Cloudflare Pages/Workers

- [x] Root `index.html` is a responsive, accessible product/promotion page with relative asset URLs so project-subpath hosting works; it covers the app concept, five slots, Group tab, current unassigned/pending work, promo artwork, deployment/download guidance, and the FED-OS community/support section. Local asset/link references were checked against the built output.
- [x] The HTML includes a working favicon link and the favicon asset is present in the repository.
- [x] Provide GitHub Pages workflow/setup documentation and Cloudflare Pages/Workers static-asset configuration with headers/redirects as needed; deploy output is `dist/` and requires no server/database/build secrets. `dist/` contains only public site files and its route manifest; no live deployment was performed.
- [x] Include accurate Open Graph metadata and `assets/og-image.png`; leave project/release URLs visibly configurable until a real repository/release URL is known. Do not publish, connect an account, or claim a live deployment.

## 4. Promo artwork is an individual, simple comedic image set

- [x] Deliver each of the eight named PNGs as its own image, in one consistent playful inked comic direction, with no garbled promotional copy baked into the art.
- [x] The named concepts are respectively: five agents fanning out of one phone; top-five-agent tabs with Muse named and slots 2–5 shown as unknown; one-tap switching; five awake slots; five sealed vault doors; five separate worlds in one phone; slots 2–5 behind a construction sign while D1 is pending; and a Git-FED mascot with an iridescent “5”.
- [x] Use promotional captions in HTML/docs rather than relying on exact image-model typography. Do not present concept artwork as proof of implemented behavior.

## 5. The documentation, prompts, and testing examples are usable and candid

- [x] `docs/ultimate-file-tree.md` records the repository layout; `DECISIONS.md` lists D1–D13 and keeps D1 OPEN; `SLOTS.md` mirrors the canonical slot data; `BUILDING.md` describes debug/CI/release signing; `TESTING.md` documents the test approach and isolation proof; and `GROUP-CHAT.md` explains setup, usage, limits, and manual sending checks.
- [x] The five prompt files cover repository build order, icon/art direction, standalone landing page, README authoring (including an explicit placeholder where Git-FED’s verbatim copy was not supplied), and the three draft promo codes `Muse 5F2V31`, `Manus G3ADN`, and `Teamily 2U6Q8D`, without inventing discounts or availability.
- [x] The two JSON flows are machine-readable sample/manual scenarios; the Group flow is read-only and never sends a message. `sample-report.md` is clearly marked SAMPLE and NOT a real test run.

## 6. Deliver a clean ZIP ready for the user’s GitHub repository

- [x] Create a ZIP containing the repository files, deployment configuration, and separately accessible promo images; exclude `.git`, signing material, Gradle caches/build outputs, and the ZIP itself.
- [x] Inspect the archive listing and validate static HTML/JSON/XML and Android Gradle structure with available lightweight checks; report that no real Android device/security isolation test or live deployment was performed. The debug APK was built and signature-verified; the source ZIP excludes build outputs.

## 7. Keep WebView navigation in-app and package launcher icons

- [x] In the Android app, opening a normal supported HTTPS link from a slot must navigate in that slot's WebView and must not send the user to the device browser. Non-HTTPS and external-app URL schemes must be blocked rather than launched externally. Source policy now allows only HTTPS WebView navigation; on-device runtime behavior still needs the documented device check.
- [x] The packaged APK must declare both standard and round launcher icons and contain valid launcher icon resources for supported densities. Manifest references and all five density fallbacks were checked.
- [x] Build and provide a debug APK if the Android SDK is available; otherwise report the concrete build blocker and still deliver the source changes and icon-enabled manifest. Built `app/build/outputs/apk/debug/app-debug.apk`; signature verified with the standard Android debug key, package metadata and icon resources checked. No Android device was connected, so link navigation has not been tap-tested on a phone.

## 8. Darken the landing page and add visible animation

- [x] Reduce the page's bright appearance with a darker, muted palette while preserving readable contrast, existing content, and responsive layout. Replaced bright paper surfaces with charcoal/slate, warm off-white text, and softened orange/teal accents; toned image saturation/brightness.
- [x] Add visible motion to the hero/artwork and scroll-entering content; animations must honor `prefers-reduced-motion` and must not make content inaccessible if JavaScript or IntersectionObserver is unavailable. Added hero drift, stamp/status/logo motion, and IntersectionObserver reveals activated only when supported and motion is allowed; fallback content remains visible.
- [x] Rebuild the static site and refresh the source ZIP with the updated HTML/CSS/JS. Build output, route manifest, CSS brace integrity, asset links, and JavaScript syntax checked.

## 9. Add FED-OS community, support, and footer links

- [x] Add the provided Discord widget (`1400235929154879490`, dark theme) as a responsive, titled, sandboxed iframe, and allow only `https://discord.com` as a frame source in the generated site Content Security Policy. Verified both Pages `_headers` output and the Cloudflare Worker response policy.
- [x] Add the supplied Patreon checkout URL as a clearly labeled $5 support action, plus the public Patreon supporter page and Buy Me a Coffee link. The provided checkout query is preserved; a stable public Patreon page is included as fallback if the direct URL expires or will not open. No payment was initiated.
- [x] Add the supplied public FED-OS footer links for Explore, Membership, Storefront, Whop, Contact, Support, Media, Artwork, and Community/Social. Include the Careers address only if active hiring is confirmed; no hiring status was supplied. Omit Facebook (marked “skip”), the personal Substack, and the direct Private Matrix link from the main footer.
- [x] Add a separate Private Communities page that warns 18+, asks users to self-attest age and eligible country from Canada, Switzerland, Russia, Iran, Somalia, and Turkmenistan, then reveals the supplied Matrix link. Explain that this static-client-side check is a courtesy gate, not actual identity/geolocation or access control.
- [x] Include the new page in the static build and route manifest, keep relative links working, rebuild the site and source ZIP, and verify the generated page/CSP/links. Both HTML pages and `/manus-routes.json` return HTTP 200 in Preview; source archive integrity and exclusions verified.

## 10. Add the supplied referral invitations to the README

- [x] Add the Muse invitation copy exactly: “Check out Muse, your personal AI agent. Redeem my code in Settings within 48 hours of joining and we'll both get 1 billion Muse tokens.” Include code `5F2V31` and link `https://muse.ai/join`.
- [x] Add `Manus Ai Invite Code: G3ADN`; do not invent a Manus URL.
- [x] Add the Teamily copy exactly: “Join me on Teamily, the human-agent platform, where you and always-on agents get work done together in one unified and context-aware space. Redeem my code in Settings - Credits Center and you'll get 5 CREDITS right away.” Include code `2U6Q8D` and link `https://teamily.ai/i/2U6Q8D`.
- [x] Refresh and validate the repository ZIP so it contains the updated README. Staging archive passed integrity, path, and invitation-copy checks; final archive is rebuilt with this completed status.
