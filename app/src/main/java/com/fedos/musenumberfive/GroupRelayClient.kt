package com.fedos.musenumberfive

import android.content.Context

/**
 * Intentionally non-operational relay boundary. The example JSON is not a protocol contract;
 * no network request is made until endpoint, wire format, authentication, and privacy behavior
 * are specified and reviewed. Keep real credentials out of source assets.
 */
class GroupRelayClient(context: Context) {
    @Suppress("unused")
    private val appContext = context.applicationContext

    val isConfigured: Boolean = false

    fun send(message: String, callback: (Result<Unit>) -> Unit) {
        val reason = if (message.isBlank()) {
            "Enter a message first."
        } else {
            "Sending is disabled: Group relay protocol and endpoint are not configured or reviewed."
        }
        callback(Result.failure(IllegalStateException(reason)))
    }
}
