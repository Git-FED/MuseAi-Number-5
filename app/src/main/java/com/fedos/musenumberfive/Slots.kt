package com.fedos.musenumberfive

/** The five tabs all open Muse.ai, with a stable, separately named WebView profile per slot. */
data class SlotDefinition(
    val number: Int,
    val label: String,
)

object Slots {
    val all: List<SlotDefinition> = (1..5).map { number ->
        SlotDefinition(number = number, label = "Muse $number")
    }

    init {
        check(all.map(SlotDefinition::number) == (1..5).toList())
    }
}
