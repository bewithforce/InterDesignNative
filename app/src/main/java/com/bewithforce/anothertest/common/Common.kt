package com.bewithforce.anothertest.common

import com.bewithforce.anothertest.retrofit.RetrofitClient
import com.bewithforce.anothertest.retrofit.RetrofitService

object Common {
    private const val BASE_URL = "https://test-family-photos.herokuapp.com/api/v1/"
    lateinit var PHONE_NUMBER: String


    val retrofitService: RetrofitService
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}