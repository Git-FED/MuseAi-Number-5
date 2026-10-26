# Build prompt — Muse Number Five

Use this prompt to guide implementation from the approved source materials. Do not treat this prompt as proof that implementation or testing has occurred.

## Objective

Build a GitHub-ready Android/Kotlin starter for an app concept with **five isolated AI-agent slots** and a **sixth Group tab**. Muse is named in slot 1. D1, the lineup for slots 2–5, is **OPEN**: leave those four slots explicitly unassigned. Do not invent their names, providers, accounts, or credentials.

## Contract and navigation

- Use the supplied original 73-core-file path contract in `docs/ultimate-file-tree.md`; do not silently count extra deployment files as part of those 73.
- Keep one data-first definition for five numbered slots. Make the slot content/profile relationship explicit and reviewable.
- Group is not slot 6. Under D13 it is a sixth tab labeled **Group**, with a group/chat semantic glyph, at page index **5** (zero-based).
- Group is strictly read-only. When configured it polls at 60 seconds; otherwise show a clear not-connected state. Never add message sending, posting, or write methods. Use placeholders only for relay URL/token.
- Do not claim separate tabs prove security isolation. Keep privacy, backup, network, and data-boundary behavior subject to tests/review.

## Build and safety

- Supply Android Gradle/Kotlin starter files and a GitHub Actions **debug build** workflow, but describe CI as a build check, not a release/security certification.
- Keep release signing manual and owner-controlled. No real keystore, passwords, signing secrets, or generated signed APK belongs in this task. Document cautious setup; never commit credentials.
- Include the slot flow as 22 manual steps and retain D11 as an unresolved release gate pending source-owner acceptance criteria and evidence. Never mark a flow passed without an actual run.
- Preserve `testing/sample-report.md` as SAMPLE, NOT A REAL RUN.

## Honesty requirements

Do not fabricate D2–D12 dispositions. Mark unspecified decisions open pending source-owner input. Do not claim an Android device test, isolation/security proof, live relay, release, signed APK, or deployment unless independently performed and evidenced. Do not edit the global root TODO or plan as a substitute for creating requested artifacts.
