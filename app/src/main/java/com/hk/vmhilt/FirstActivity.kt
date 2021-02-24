package com.hk.vmhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FirstActivity : AppCompatActivity() {

    val TAG = "FirstActivity"
    @Inject
    lateinit var cricket: Cricket
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        println("$TAG Cricketer object-> $cricket")
    }
}