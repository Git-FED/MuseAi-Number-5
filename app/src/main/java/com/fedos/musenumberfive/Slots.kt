package com.fedos.musenumberfive

/** Canonical display metadata only; this is not a security or storage-isolation boundary. */
data class SlotDefinition(
    val number: Int,
    val label: String,
    val isAssigned: Boolean,
)

object Slots {
    const val UNASSIGNED_LABEL = "Unassigned"

    val all: List<SlotDefinition> = listOf(
        SlotDefinition(number = 1, label = "Muse", isAssigned = true),
        SlotDefinition(number = 2, label = UNASSIGNED_LABEL, isAssigned = false),
        SlotDefinition(number = 3, label = UNASSIGNED_LABEL, isAssigned = false),
        SlotDefinition(number = 4, label = UNASSIGNED_LABEL, isAssigned = false),
        SlotDefinition(number = 5, label = UNASSIGNED_LABEL, isAssigned = false),
    )

    init {
        check(all.map(SlotDefinition::number) == (1..5).toList())
        check(all.drop(1).none(SlotDefinition::isAssigned))
    }
}
