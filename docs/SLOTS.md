# Slot lineup

The app concept has **five isolated AI-agent slots** and a separate **sixth Group tab**. Slot numbering is stable. “Isolated” describes the intended product organization; it is not a claim that security or data isolation has been independently verified.

| Slot | Display identity | Provider | Status |
|---:|---|---|---|
| 1 | **Muse** | Not specified | Named in the source. |
| 2 | Unassigned | Unassigned | D1 open; do not invent a name or provider. |
| 3 | Unassigned | Unassigned | D1 open; do not invent a name or provider. |
| 4 | Unassigned | Unassigned | D1 open; do not invent a name or provider. |
| 5 | Unassigned | Unassigned | D1 open; do not invent a name or provider. |

## Sixth tab: Group

Group is an additional tab at zero-based page index **5**, with the tab label **Group** and a group/chat semantic glyph under D13. It is not slot 6, does not fill any of slots 2–5, and does not change their open lineup status.

The Group example is read-only: when configured, it may poll at a 60-second interval; when not configured/connected, it must present a clear not-connected state. The example flow must **NEVER send**. Relay endpoint and credentials are placeholders, never real secrets.

## Safe naming rule

Use “Unassigned” for slots 2–5 until D1 is resolved. Do not imply that these slots have providers, accounts, credentials, or operational agents. Any eventual mapping must be approved and separately tested. No claims of cross-slot security isolation follow merely from separate tabs or profile objects.
