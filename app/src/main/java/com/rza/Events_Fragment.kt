package com.rza

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.fragment_events.*
import android.view.KeyEvent.KEYCODE_BACK
import android.webkit.WebSettings


class Events_Fragment : Fragment() {
    val eventsURL = "http://gammas.org/events/"
//    val mywebviewURL = "https://www.facebook.com/pg/gammazetaalpha/events/?ref=page_internal"
    val TAG = "Events_Fragment"

    override fun onAttach(context: Context?) {
        Log.d(TAG, "onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_events, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
        // events_webview.loadUrl(webviewUrl)
        events_webview.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url);
                return true
            }
        })

        val webSettings = events_webview.getSettings();
        events_webview.getSettings().setJavaScriptEnabled(true);
        events_webview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        events_webview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        events_webview.getSettings().setAppCacheEnabled(true);
        events_webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        events_webview.loadUrl(eventsURL)
    }

    override fun onDetach() {
        Log.d(TAG, "onDetach")
        super.onDetach()
    }
}
