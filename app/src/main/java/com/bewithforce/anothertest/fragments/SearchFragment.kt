package com.bewithforce.anothertest.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.bewithforce.anothertest.R
import com.bewithforce.anothertest.common.Common
import com.bewithforce.anothertest.model.Data
import com.bewithforce.anothertest.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {

    lateinit var mService: RetrofitService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mService = Common.retrofitService
    }

    override fun onStart() {
        super.onStart()
        val editText = view?.findViewById<EditText>(R.id.searchParamEditText)

        val button = view?.findViewById<Button>(R.id.searchButton)
        button?.setOnClickListener {
            Log.e("clicked", "veeeeeeeeeeeeeeeeee")
            mService.getValue("375291700124", editText?.text.toString())
                .enqueue(object : Callback<Data> {
                    override fun onResponse(
                        call: Call<Data>,
                        response: Response<Data>
                    ) {
                        Log.e("responsed", response.message())

                        val newFragment = TableFragment()
                        val bundle = Bundle()
                        bundle.putParcelable("data", response.body())
                        newFragment.arguments = bundle
                        fragmentManager!!
                            .beginTransaction()
                            .replace(R.id.fragment, newFragment)
                            .commit()
                    }

                    override fun onFailure(call: Call<Data>, t: Throwable) {
                        Log.e("failed", "veeeeeeeeeeeeee")
                        Log.e("failed", t.message!!)
                    }

                })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        container?.removeAllViews()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }
}