package com.bewithforce.anothertest.retrofit

import com.bewithforce.anothertest.model.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("old_phone/csv")
    fun getValue(@Query("key") key: String, @Query("value") value: String): Call<Data>
}