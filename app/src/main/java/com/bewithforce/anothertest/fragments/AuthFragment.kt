package com.bewithforce.anothertest.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.bewithforce.anothertest.R
import com.bewithforce.anothertest.common.Common


class AuthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_auth, container, false)
    }

    override fun onStart() {
        super.onStart()

        val editText = view?.findViewById<EditText>(R.id.authPhoneNumberEditText)

        val button = view?.findViewById<Button>(R.id.authButton)
        button?.setOnClickListener{
            val settings = this.activity?.getSharedPreferences("AUTHORIZATION", 0)
            Log.e("fucking", settings.toString())
            val editor = settings!!.edit()
            editor!!.putBoolean("auth", true)
            editor?.putString("phoneNumber", editText?.text.toString())
            editor?.apply()

            Common.PHONE_NUMBER = editText?.text.toString()

            //fragmentManager!!.popBackStack()
            fragmentManager!!
                .beginTransaction()
                .replace(R.id.fragment, SearchFragment())
                .commit()
        }


    }
}