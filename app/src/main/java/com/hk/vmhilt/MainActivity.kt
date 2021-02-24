package com.hk.vmhilt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    @Inject
    @Named("main string")
    lateinit var mainString: String
    @Inject
    lateinit var cricket: Cricket

    //sorry not to use databinding, lazy to add dataBinding dependency.
    lateinit var openFirstActivityButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openFirstActivityButton = findViewById(R.id.btn_open_first_activity)
        openFirstActivityButton.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }

        println("$TAG Main String -> $mainString")

        println("$TAG Cricketer Name -> ${cricket.getCricketerName()}")
        println("$TAG Cricketer Address -> ${cricket.address.getAddress()}")

        println("$TAG Cricketer object -> $cricket")
    }
}

/**
 * constructor injection.
 * we are injecting name field.
 * we use @Inject to tell Hilt How to make the object of this Cricket class
 */
@Singleton
class Cricket @Inject constructor (@Named("cricketer string") private var name: String?, var address: Address) {

    fun getCricketerName() : String? {
        return name
    }
}

class Address @Inject constructor() {

    fun getAddress(): String {
        return "Ranchi"
    }
}


