package com.bewithforce.anothertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bewithforce.anothertest.common.Common
import com.bewithforce.anothertest.fragments.AuthFragment
import com.bewithforce.anothertest.fragments.SearchFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences =  applicationContext.getSharedPreferences("AUTHORIZATION", 0)
        val auth = sharedPreferences.getBoolean("auth", false)

        if(auth){
            Log.e("asdasd", "delete this device")
            Common.PHONE_NUMBER = sharedPreferences.getString("phoneNumber", "+375000000000").toString()

            val fragmentInFrame = supportFragmentManager.findFragmentById(R.id.fragment)
            if(fragmentInFrame is AuthFragment){
                supportFragmentManager.popBackStack()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, SearchFragment())
                    .commit()
               // supportFragmentManager.executePendingTransactions()
            }
        } else {
         //   supportFragmentManager.popBackStack()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment, AuthFragment())
                .commit()
        }


    }


}