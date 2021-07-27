package com.example.gapiapp.dto

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("r/php/search.json?q=oop&limit=5")
    suspend fun getItems():Response<RedditResponse>
}