package com.example.topheadlines.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.topheadlines.R
import com.example.topheadlines.view.fragement.RecycleViewFragment

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragement()

    }

    private fun addFragement(){
        val fragmentManger = supportFragmentManager
        val fragmentTransaction = fragmentManger.beginTransaction()
        fragmentTransaction.add(R.id.fl_fragment, RecycleViewFragment())
            //.addToBackStack(null)
            .commit()
    }

}
