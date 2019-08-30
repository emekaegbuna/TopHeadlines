package com.example.topheadlines.network

import com.example.topheadlines.model.TopHeadlines
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlineAPIInterface {

    @GET("top-headlines?country=us&apiKey=d444d444e40c4c1db61339cdd9aaca3d")
    fun getTopHeadlines(@Query("country") country:String, @Query("apiKey") apiKey:String): Call<TopHeadlines?>
}