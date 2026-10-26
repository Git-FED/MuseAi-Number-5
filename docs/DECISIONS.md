# Decisions and open items

This register records source decisions and the user's requested lineup change. It does not infer decisions from implementation convenience. Items marked open require source-owner input; “unspecified” means no disposition was provided, not that a particular option was rejected.

| ID | Status | Source-grounded record |
|---|---|---|
| D1 | **RESOLVED FOR THIS BUILD** | The user requested five Muse.ai instances. Slots 1–5 all open `https://muse.ai/`, each using its own stable named WebView profile (`muse-slot-1` through `muse-slot-5`). |
| D2 | **OPEN — unspecified** | The supplied source gives no disposition. Request the decision and rationale from the source owner. |
| D3 | **OPEN — unspecified** | The supplied source gives no disposition. Request the decision and rationale from the source owner. |
| D4 | **OPEN — unspecified** | The supplied source gives no disposition. Request the decision and rationale from the source owner. |
| D5 | **OPEN — unspecified** | The supplied source gives no disposition. Request the decision and rationale from the source owner. |
| D6 | **OPEN — unspecified** | The supplied source gives no disposition. Request the decision and rationale from the source owner. |
| D7 | **OPEN — unspecified** | The supplied source gives no disposition. Request the decision and rationale from the source owner. |
| D8 | **OPEN — unspecified** | The supplied source gives no disposition. Request the decision and rationale from the source owner. |
| D9 | **OPEN — unspecified** | The supplied source gives no disposition. Request the decision and rationale from the source owner. |
| D10 | **OPEN — unspecified** | The supplied source gives no disposition. Request the decision and rationale from the source owner. |
| D11 | **OPEN — gate details unspecified** | The slot flow is described as 22 steps and a release gate keyed to D11. The source does not provide the detailed D11 acceptance criteria or evidence that the gate passed. Preserve it as a release gate; do not claim completion. |
| D12 | **OPEN — unspecified** | The supplied source gives no disposition. Request the decision and rationale from the source owner. |
| D13 | **DEFINED (limited facts)** | Defines a sixth tab labeled **Group**, a Group/group-chat glyph, and page index **5** (zero-based). Group is in addition to the five Muse.ai tabs, not one of them. The precise glyph asset/geometry is not specified here. |

## Required handling

- Keep the five Muse.ai destinations and profile IDs consistent unless the source owner requests a different lineup.
- Keep D2–D12 other than the recorded D11 flow/gate fact marked unspecified/open pending source-owner input. No undocumented disposition is implied by this register.
- Implementing a tab label/index or a sample flow is not proof of isolation, release readiness, or a passed D11 gate.
- The Group flow is read-only and must never send. Relay examples contain placeholders only.
