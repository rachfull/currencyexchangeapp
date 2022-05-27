package com.example.exchangeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var currFrag = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currFrag == null) {
            currFrag = WelcomeFragment()
            //  currFrag.registerListener(this)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, currFrag)
                .commit()
        }
    }
}