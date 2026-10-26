package com.fedos.musenumberfive

/** Stable profile IDs keep each slot's Muse.ai cookies and web storage in its own WebView profile. */
object MultiProfile {
    fun profileNameFor(slot: SlotDefinition): String = "muse-slot-${slot.number}"
}
