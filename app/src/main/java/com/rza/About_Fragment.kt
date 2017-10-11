package com.rza

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_about.*

class About_Fragment : Fragment() {
    val TAG = "FramentAbout"

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView")
        return inflater!!.inflate(R.layout.fragment_about, container, false)
    }

    override fun onAttach(context: Context?) {
        Log.d(TAG, "onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        // about link cicklable
        more_info.movementMethod = LinkMovementMethod.getInstance()

        ib_facebook.setOnClickListener {
            val myWebLink = Intent(Intent.ACTION_VIEW)
            myWebLink.data = Uri.parse("https://www.facebook.com/gammazetaalpha/")
            startActivity(myWebLink)
            // toast("opening facebook webView");
        }

        ib_twitter.setOnClickListener() {
            val myWebLink = Intent(Intent.ACTION_VIEW)
            myWebLink.data = Uri.parse("https://twitter.com/gammazetaalpha")
            startActivity(myWebLink)
            // toast("opening twitter webView");

            ib_instagram.setOnClickListener() {
                val myWebLink = Intent(Intent.ACTION_VIEW)
                myWebLink.data = Uri.parse("https://www.instagram.com/gammas_sjsu/")
                startActivity(myWebLink)
                // toast("opening instagram webView");
            }
        }

        Log.d(TAG, "onStart")
        super.onStart()
    }

    override fun onDetach() {
        Log.d(TAG, "onDetach")
        super.onDetach()
    }
}
