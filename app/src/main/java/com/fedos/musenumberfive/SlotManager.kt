package com.fedos.musenumberfive

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.webkit.WebViewCompat
import androidx.webkit.WebViewFeature

/** Keeps one Muse.ai WebView and named browsing profile per slot. */
class SlotManager(context: Context, private val container: FrameLayout) {
    private val appContext = context.applicationContext
    private val slots = mutableMapOf<Int, SlotPane>()

    fun show(slot: SlotDefinition) {
        val pane = slots.getOrPut(slot.number) { createSlotPane(slot) }
        (pane.root.parent as? ViewGroup)?.removeView(pane.root)
        container.removeAllViews()
        container.addView(
            pane.root,
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
            ),
        )
    }

    @SuppressLint("SetJavaScriptEnabled", "RequiresFeature")
    private fun createSlotPane(slot: SlotDefinition): SlotPane {
        val root = FrameLayout(appContext)
        val message = TextView(appContext).apply {
            gravity = Gravity.CENTER
            setTextColor(Color.rgb(54, 48, 44))
            textSize = 16f
            setPadding(dp(28), dp(24), dp(28), dp(24))
            visibility = View.GONE
            setBackgroundColor(Color.rgb(255, 250, 240))
        }
        val progress = ProgressBar(appContext, null, android.R.attr.progressBarStyleHorizontal).apply {
            max = 100
            visibility = View.GONE
        }

        if (!WebViewFeature.isFeatureSupported(WebViewFeature.MULTI_PROFILE)) {
            message.text = "This device's Android System WebView does not support separate slot profiles. Update Android System WebView (or Chrome), then reopen Muse Number Five."
            message.visibility = View.VISIBLE
            root.addView(message, FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
            ))
            return SlotPane(root = root, webView = null)
        }

        val webView = WebView(appContext)
        // Must be assigned before settings, clients, or navigation are configured.
        WebViewCompat.setProfile(webView, MultiProfile.profileNameFor(slot))
        WebViewCompat.getProfile(webView).cookieManager.setAcceptCookie(true)

        webView.apply {
            setBackgroundColor(Color.rgb(255, 250, 240))
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.loadsImagesAutomatically = true
            settings.allowFileAccess = false
            settings.allowContentAccess = false
            settings.mixedContentMode = android.webkit.WebSettings.MIXED_CONTENT_NEVER_ALLOW
            settings.safeBrowsingEnabled = true
            settings.javaScriptCanOpenWindowsAutomatically = false
            settings.setSupportMultipleWindows(false)
            settings.mediaPlaybackRequiresUserGesture = true
            isFocusable = true
            isFocusableInTouchMode = true
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                    // Keep HTTPS navigation (including redirects) inside this slot. Block insecure
                    // and non-web schemes rather than handing them to another app.
                    return !request.url.scheme.equals("https", ignoreCase = true)
                }

                override fun onPageStarted(view: WebView, url: String?, favicon: android.graphics.Bitmap?) {
                    message.visibility = View.GONE
                    super.onPageStarted(view, url, favicon)
                }

                override fun onReceivedError(
                    view: WebView,
                    request: WebResourceRequest,
                    error: android.webkit.WebResourceError,
                ) {
                    super.onReceivedError(view, request, error)
                    if (request.isForMainFrame) {
                        message.text = "Muse.ai couldn't be reached. Check your internet connection and tap here to retry."
                        message.visibility = View.VISIBLE
                    }
                }
            }
            webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView, newProgress: Int) {
                    super.onProgressChanged(view, newProgress)
                    progress.progress = newProgress
                    progress.visibility = if (newProgress in 1..99) View.VISIBLE else View.GONE
                }
            }
        }

        message.setOnClickListener {
            message.visibility = View.GONE
            webView.loadUrl(MUSE_URL)
        }
        root.addView(webView, FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT,
        ))
        root.addView(progress, FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            dp(3),
            Gravity.TOP,
        ))
        root.addView(message, FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT,
        ))
        webView.loadUrl(MUSE_URL)
        return SlotPane(root = root, webView = webView)
    }

    private fun dp(value: Int): Int = (value * appContext.resources.displayMetrics.density).toInt()

    fun destroy() {
        container.removeAllViews()
        slots.values.forEach { pane ->
            pane.root.removeAllViews()
            pane.webView?.let { webView ->
                webView.stopLoading()
                webView.webChromeClient = null
                webView.destroy()
            }
        }
        slots.clear()
    }

    private data class SlotPane(
        val root: FrameLayout,
        val webView: WebView?,
    )

    companion object {
        private const val MUSE_URL = "https://muse.ai/"
    }
}
