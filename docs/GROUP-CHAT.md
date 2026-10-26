# Group tab and read-only relay example

Group is the sixth tab, in addition to five isolated AI-agent slots. D13 gives it the label **Group**, a group/chat semantic glyph, and zero-based page index **5**. It is not a sixth agent slot.

## Connection states and polling

- **Not connected:** when relay configuration is missing, invalid, or unavailable, show an explicit not-connected state. Do not imply that messages are live.
- **Configured:** the described chat behavior polls every **60 seconds**. Show the last successful update/error clearly where applicable; do not silently claim freshness.
- **Read-only, always:** the flow may retrieve/display messages, but it must **NEVER send**. No send control, write request, posting API, or outbound message is authorized by this contract. This restriction applies to test flows as well as examples.

## Relay configuration

Keep endpoints and credentials as placeholders in examples. For example:

```json
{
  "relay_url": "https://REPLACE-WITH-APPROVED-RELAY.example.invalid/read-only",
  "access_token": "PLACEHOLDER_NOT_A_SECRET",
  "poll_interval_seconds": 60,
  "mode": "read_only"
}
```

This is illustrative placeholder data, not a working relay. Do not paste real credentials into the repository. Any future endpoint must be approved and configured outside source-controlled examples. Enforce transport/security requirements in implementation and review them separately; this document does not certify them.

## Manual checks

1. With no config, open Group and confirm the not-connected state; verify no network send occurs.
2. With a controlled read-only test source configured, check the stated 60-second poll interval and message rendering.
3. Disconnect or make the source unavailable; confirm a truthful error/stale state and recovery behavior.
4. Inspect requests/logs to ensure reads only. **Do not send a message** during this scenario.

The JSON Group flow is a manual scenario, not an executed test. No relay is established or validated here.
