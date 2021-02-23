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
     *
     * we mark our field injection with the @Inject annotation,
     * thus telling Hilt that we need this dependency injected within this activity container.
     */
    @Inject
    @Named("main string")
    lateinit var mainString: String
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
 * we use @Inject to tell Hilt How to make the object of this Cricket class
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


