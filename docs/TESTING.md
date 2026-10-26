# Testing approach and evidence status

The JSON files in `testing/` are proposed manual scenarios, not execution records. **No flow is claimed to have been run.** The accompanying report is conspicuously labeled SAMPLE, NOT A REAL RUN. A debug APK was built, but it was not installed on a device in this environment.

## Slot flow and D11 gate

The supplied slot-flow description is **22 steps** and a **release gate D11**. `muse-number-five.flow.json` preserves 22 ordered manual checkpoints. D11's detailed acceptance criteria were not supplied; the flow's last checkpoint therefore requires the owner to provide and approve those criteria. The gate must remain blocked until the approved requirements and evidence are recorded. The presence of a 22-step file is not a passed gate.

Manual coverage should include tab order, correct slot-to-content mapping, independent navigation/state, lifecycle/recreation behavior, and checks that one slot does not display another slot's content. These are test intentions. Strong isolation claims require a threat model, implementation review, and device-level verification; separate UI tabs are not proof of security isolation.

## Group scenario

`muse-number-five-group.flow.json` is read-only. It checks the not-connected state, configured polling at 60 seconds, placeholder config handling, and display of received fixture data. It **must never send**: do not add a send action, transmit test text, or treat relay examples as permission to post. Use only a controlled, read-only test source if a real endpoint is later configured.

## Suggested checks when implementation exists

- Parse JSON fixtures and validate Android XML/Gradle structure.
- Run the debug build and available unit/UI checks; preserve logs and tool versions.
- In a built app, open an HTTPS page from a slot and verify it remains in that slot's WebView; try an HTTP URL and external-app schemes such as `intent:`, `tel:`, and `mailto:` and verify none launches the browser or another app.
- Verify the installed launcher shows the intended icon on both adaptive-icon and legacy density targets.
- Verify six tabs: five slots plus Group at page index 5; verify Group label and glyph semantics.
- Test disconnected and configured Group modes, including the 60-second polling interval and error recovery, without transmitting messages.
- Review backup/export behavior, network policy, storage, logs, and cross-slot state on representative devices. Treat findings as evidence only for the exact tested build/device/configuration.
- Record failures and unresolved criteria instead of rewriting a sample report as a pass.

No release signing, release-signed APK, independent security review, real-device navigation/isolation test, Group relay connection, or live deployment is evidenced by these documents.
