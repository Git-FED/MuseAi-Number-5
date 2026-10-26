package com.fedos.musenumberfive

/**
 * UI-facing profile labels only. Android WebView does not provide a per-instance profile API
 * through this scaffold; cookies, cache, service workers, and process behavior have not been
 * verified as isolated. Do not connect accounts until the isolation design is reviewed and tested.
 */
data class SlotProfile(
    val slotNumber: Int,
    val displayName: String,
    val configured: Boolean,
)

object MultiProfile {
    fun profileFor(slot: SlotDefinition): SlotProfile = SlotProfile(
        slotNumber = slot.number,
        displayName = if (slot.isAssigned) slot.label else "Slot ${slot.number} · unassigned",
        configured = false,
    )
}
