package com.fedos.musenumberfive

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    private lateinit var slotManager: SlotManager
    private var selectedTab = 0
    private lateinit var slotContainer: View
    private lateinit var groupContainer: View
    private lateinit var tabs: List<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        slotContainer = findViewById(R.id.slot_container)
        groupContainer = findViewById(R.id.group_container)
        tabs = listOf(
            findViewById(R.id.tab_slot_1),
            findViewById(R.id.tab_slot_2),
            findViewById(R.id.tab_slot_3),
            findViewById(R.id.tab_slot_4),
            findViewById(R.id.tab_slot_5),
            findViewById(R.id.tab_group),
        )
        slotManager = SlotManager(this, findViewById(R.id.slot_container))

        if (supportFragmentManager.findFragmentByTag(GROUP_FRAGMENT_TAG) == null) {
            supportFragmentManager.commit {
                add(R.id.group_container, GroupChatFragment(), GROUP_FRAGMENT_TAG)
            }
        }

        val savedTab = savedInstanceState?.getInt(STATE_SELECTED_TAB) ?: 0
        selectTab(savedTab.coerceIn(0, 5))
        tabs.forEachIndexed { index, tab -> tab.setOnClickListener { selectTab(index) } }
    }

    private fun selectTab(index: Int) {
        selectedTab = index
        tabs.forEachIndexed { tabIndex, tab ->
            val selected = tabIndex == index
            tab.isSelected = selected
            tab.setTextColor(if (selected) Color.WHITE else Color.rgb(54, 48, 44))
            tab.setBackgroundColor(if (selected) Color.rgb(168, 64, 32) else Color.rgb(255, 250, 240))
            tab.contentDescription = when (tabIndex) {
                0 -> "Slot 1, Muse" + if (selected) ", selected" else ""
                5 -> "Group tab" + if (selected) ", selected" else ""
                else -> "Slot ${tabIndex + 1}, unassigned" + if (selected) ", selected" else ""
            }
        }

        if (index < Slots.all.size) {
            groupContainer.visibility = View.GONE
            slotContainer.visibility = View.VISIBLE
            slotManager.show(Slots.all[index])
        } else {
            slotContainer.visibility = View.GONE
            groupContainer.visibility = View.VISIBLE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(STATE_SELECTED_TAB, selectedTab)
        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        if (::slotManager.isInitialized) slotManager.destroy()
        super.onDestroy()
    }

    companion object {
        private const val STATE_SELECTED_TAB = "selected_tab"
        private const val GROUP_FRAGMENT_TAG = "group_chat"
    }
}
