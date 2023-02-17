package com.example.taskapp.network

import com.example.taskapp.models.MovieModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("Top250Movies")
    suspend fun getMovies(
        @Query("apiKey") apiKey : String,
    ): Response<MovieModel>
}