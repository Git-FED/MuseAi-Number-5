package com.fedos.musenumberfive

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GroupChatFragment : Fragment(R.layout.fragment_group_chat) {
    private var messageAdapter: GroupMessageAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val relay = GroupRelayClient(requireContext())
        val status = view.findViewById<TextView>(R.id.group_status)
        val composer = view.findViewById<EditText>(R.id.group_composer)
        val send = view.findViewById<Button>(R.id.group_send)
        val list = view.findViewById<RecyclerView>(R.id.group_messages)

        status.text = GroupTab.STATUS + " Messages are not sent or synced by this starter."
        composer.isEnabled = relay.isConfigured
        send.isEnabled = relay.isConfigured
        send.setOnClickListener {
            // Kept as an explicit disabled boundary; no Group flow or send task is implemented.
            relay.send(composer.text.toString()) { }
        }

        messageAdapter = GroupMessageAdapter(
            listOf(
                GroupMessage(
                    author = "System",
                    body = "Group is a sixth-tab UI scaffold. Relay setup is pending.",
                    timestampLabel = "",
                ),
            ),
        )
        list.layoutManager = LinearLayoutManager(requireContext())
        list.adapter = messageAdapter
    }

    override fun onDestroyView() {
        view?.findViewById<RecyclerView>(R.id.group_messages)?.adapter = null
        messageAdapter = null
        super.onDestroyView()
    }

    private class GroupMessageAdapter(private val messages: List<GroupMessage>) :
        RecyclerView.Adapter<GroupMessageAdapter.MessageViewHolder>() {

        class MessageViewHolder(val text: TextView) : RecyclerView.ViewHolder(text)

        override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): MessageViewHolder {
            val text = android.widget.TextView(parent.context).apply {
                setPadding(20, 16, 20, 16)
                textSize = 16f
                setTextColor(android.graphics.Color.rgb(40, 36, 32))
            }
            return MessageViewHolder(text)
        }

        override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
            val item = messages[position]
            holder.text.text = if (item.timestampLabel.isBlank()) {
                "${item.author}: ${item.body}"
            } else {
                "${item.author} · ${item.timestampLabel}\n${item.body}"
            }
        }

        override fun getItemCount(): Int = messages.size
    }
}
