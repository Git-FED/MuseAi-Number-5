# Building and signing notes

The debug APK was built successfully with Android SDK Platform 34 and Build-Tools 34.0.0. It uses the standard Android debug key and is not a release artifact. No release-signing setup, release APK, or security proof is supplied.

## Debug build and CI

The debug APK is produced at `app/build/outputs/apk/debug/app-debug.apk` by running `./gradlew assembleDebug` from the repository root. On Windows, use `gradlew.bat assembleDebug`. The current debug artifact was signed with the standard Android debug certificate and its signature was verified. The APK's package metadata and launcher resources were checked. It was not installed on a physical device because no Android device was connected.

The GitHub Actions workflow (`.github/workflows/build.yml`) builds debug on pushes and pull requests. CI debug success does not prove release signing, runtime behavior, privacy properties, isolation, or store readiness. Avoid logging secrets and avoid making signing credentials available to pull-request workflows.

## Release signing: manual, security-sensitive setup

Release signing requires an owner-controlled keystore and credentials. None are supplied here. `keystore.properties.example` is only an example file name; it must contain unmistakable placeholders, never usable passwords or key material.

Before enabling release signing:

1. Have the release owner create and securely back up a dedicated signing key using an approved process, with access limited to authorized maintainers.
2. Keep the keystore and real passwords out of Git, archives, CI logs, issue trackers, and this documentation. Prefer protected CI secrets or an ignored, access-controlled local properties file; do not commit local credentials.
3. Review the Gradle signing configuration and verify that absent credentials do not silently produce a misleadingly signed or distributable release.
4. Restrict signing jobs to trusted protected branches/tags and authorized release operators; do not expose signing secrets to untrusted pull requests.
5. Verify the resulting artifact signature and provenance independently, document custody/rotation procedures, and have the release owner approve publication.

These are setup precautions, not evidence that a keystore has been created, configured, or used. At this time there is **no actual release/security proof and no release-signed APK**. The debug APK uses the standard debug key and is not suitable for public release. Do not treat debug/CI output as proof of slot isolation or Group safety.
