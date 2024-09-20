package com.tweetsycompose.app.api

import com.tweetsycompose.app.models.TweetList
import com.tweetsycompose.app.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyApi {


    @GET("v3/b/66ed050facd3cb34a887d2b5?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetListItem>>


    @GET("v3/b/66ed050facd3cb34a887d2b5?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories(): Response<List<String>>

}