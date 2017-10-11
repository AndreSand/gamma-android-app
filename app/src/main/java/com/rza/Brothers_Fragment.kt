package com.rza

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.fragment_brothers.*
import kotlinx.android.synthetic.main.fragment_events.*
import android.graphics.Bitmap
import android.webkit.WebSettings





/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Brothers_Fragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Brothers_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Brothers_Fragment : Fragment() {
    val brothersURL = "http://gammas.org/about-gammas/board-of-directors/"
    val TAG = "Brothers_Fragment"

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
        return inflater!!.inflate(R.layout.fragment_brothers, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()

        // brothers_webview.loadUrl(webviewUrl)
        brothers_webview.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url);
                return true
            }
        })

        val webSettings = brothers_webview.getSettings();
        brothers_webview.getSettings().setJavaScriptEnabled(true);
        brothers_webview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        brothers_webview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        brothers_webview.getSettings().setAppCacheEnabled(true);
        brothers_webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        brothers_webview.loadUrl(brothersURL)
    }

    override fun onDetach() {
        Log.d(TAG, "onDetach")
        super.onDetach()
    }
}
