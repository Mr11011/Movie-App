package com.example.moviesapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "644a10f035ca4d11b1504511b3315fb8"

interface APIServices {

    @GET("movie/popular")

    fun getNowPlayingMovies(
        @Query("api_key")
        api_key: String = API_KEY,
        @Query("page")
        page: Int
    ): Call<MovieResponse>

    @GET("movie/upcoming")
    fun getPopularMovies(
        @Query("api_key")
        api_key: String = API_KEY,
    ): Call<MovieResponse>

}