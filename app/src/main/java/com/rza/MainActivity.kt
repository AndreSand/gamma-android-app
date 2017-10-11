package com.rza

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isFragment_About_Loaded = true
    val manager = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                Show_About_Fragment()
//                message.setText(R.string.title_home)
                // Create an Intent to start the second activity
                // val randomIntent = Intent(this, About::class.java)
                // Start the new activity.
                //startActivity(randomIntent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                Show_Brothers_Fragment()
//                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                Show_Events_Fragment()
//                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        Show_About_Fragment()
    }

    fun Show_About_Fragment() {
        val transaction = manager.beginTransaction()
        val fragment = About_Fragment()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragment_About_Loaded = true
    }

    fun Show_Brothers_Fragment() {
        val transaction = manager.beginTransaction()
        val fragment = Brothers_Fragment()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragment_About_Loaded = true
    }

    fun Show_Events_Fragment() {
        val transaction = manager.beginTransaction()
        val fragment = Events_Fragment()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragment_About_Loaded = true
    }
}

