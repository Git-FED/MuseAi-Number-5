package com.fedos.musenumberfive

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout

/** Manages five local placeholder WebViews; no remote providers or per-slot profiles are configured. */
class SlotManager(context: Context, private val container: FrameLayout) {
    private val appContext = context.applicationContext
    private val webViews = mutableMapOf<Int, WebView>()

    fun show(slot: SlotDefinition) {
        val webView = webViews.getOrPut(slot.number) { createWebView(slot) }
        (webView.parent as? ViewGroup)?.removeView(webView)
        container.removeAllViews()
        container.addView(
            webView,
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
            ),
        )
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun createWebView(slot: SlotDefinition): WebView = WebView(appContext).apply {
        setBackgroundColor(Color.rgb(255, 250, 240))
        settings.javaScriptEnabled = false
        settings.domStorageEnabled = false
        settings.databaseEnabled = false
        settings.allowFileAccess = false
        settings.allowContentAccess = false
        settings.mixedContentMode = android.webkit.WebSettings.MIXED_CONTENT_NEVER_ALLOW
        settings.safeBrowsingEnabled = true
        isFocusable = true
        settings.javaScriptCanOpenWindowsAutomatically = false
        settings.setSupportMultipleWindows(false)
        webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                // Return false for HTTPS so WebView handles navigation in this same slot.
                // Consume HTTP and non-web schemes; never hand links off to another app/browser.
                return !request.url.scheme.equals("https", ignoreCase = true)
            }
        }
        val escapedLabel = slot.label
            .replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace("\"", "&quot;")
            .replace("'", "&#39;")
        val template = appContext.assets.open("slot-placeholder.html")
            .bufferedReader(Charsets.UTF_8)
            .use { it.readText() }
        loadDataWithBaseURL(
            "https://appassets.androidplatform.net/assets/",
            template.replace("{{SLOT_LABEL}}", escapedLabel),
            "text/html",
            "UTF-8",
            null,
        )
    }

    fun destroy() {
        container.removeAllViews()
        webViews.values.forEach { view ->
            (view.parent as? ViewGroup)?.removeView(view)
            view.stopLoading()
            view.destroy()
        }
        webViews.clear()
    }
}
