package com.mobile.withings.retrofit

import com.mobile.withings.BuildConfig
import com.mobile.withings.model.ImageResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {



    @GET("/api/")
     fun searchImage(
        @Query("q") searchQuery:String,
        @Query("key") apiKey: String = BuildConfig.API_KEY
    ): Call<ImageResponse>
}