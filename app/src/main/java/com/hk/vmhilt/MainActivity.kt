package com.hk.vmhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    /**
     * Field Injection
     */
    @Inject
    @Named("main string")
    lateinit var mainString: String

    /**
     * Field Injection
     */
    @Inject
    lateinit var cricket: Cricket

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        println("$TAG Main String -> $mainString")

        println("$TAG Cricketer Name -> ${cricket.getCricketerName()}")
        println("$TAG Cricketer Address -> ${cricket.address.getAddress()}")
    }
}

/**
 * constructor injection.
 * we are injecting name field.
 */
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


