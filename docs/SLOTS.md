# Slot lineup

The app has five Muse.ai tabs and a separate sixth Group tab. All five Muse tabs start at the same URL, `https://muse.ai/`, and use stable, separately named WebView profiles.

| Slot | Display identity | Starting URL | WebView profile |
|---:|---|---|---|
| 1 | **Muse 1** | `https://muse.ai/` | `muse-slot-1` |
| 2 | **Muse 2** | `https://muse.ai/` | `muse-slot-2` |
| 3 | **Muse 3** | `https://muse.ai/` | `muse-slot-3` |
| 4 | **Muse 4** | `https://muse.ai/` | `muse-slot-4` |
| 5 | **Muse 5** | `https://muse.ai/` | `muse-slot-5` |

## Profile behavior and limits

On Android System WebView versions that support AndroidX WebKit's multi-profile feature, each slot's cookies and web storage are kept in its own persistent named profile. Sign in to the account intended for each tab separately. The app checks for multi-profile support and shows an update message instead of silently falling back to the shared default profile.

Separate WebView profiles are not separate Android processes or a complete security sandbox. Confirm the actual WebView provider/version, sign-in and redirects, profile persistence, lifecycle behavior, backup behavior, and cross-slot data separation on target devices before relying on the separation for sensitive use.

## Sixth tab: Group

Group is an additional tab at zero-based page index **5**, with the tab label **Group** and a group/chat semantic glyph under D13. It is not a Muse slot. The Group example is read-only: when configured, it may poll at a 60-second interval; when not configured/connected, it must present a clear not-connected state. The example flow must **NEVER send**. Relay endpoint and credentials are placeholders, never real secrets.
