package com.example.moviesapp

import com.example.moviesapp.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface APIServices {

    @GET("/3/movie/popular?api_key=644a10f035ca4d11b1504511b3315fb8/")
    fun getMovieList(): Call<MovieResponse>

}

























//
//
////private const val API_KEY = "644a10f035ca4d11b1504511b3315fb8&page=1"
////private val Mochi1 = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
////private val retrofit =
////    Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(Mochi1)).baseUrl(
////       API_KEY
////    ).build()
//
//interface APIServices {
//    @GET("/3/movie/popular?api_key=644a10f035ca4d11b1504511b3315fb8/")
//    fun getMovieList(
//    ): Call<List<MovieResponse>>
//}
//
//
////    https://api.themoviedb.org/3/movie/popular?api_key=644a10f035ca4d11b1504511b3315fb8&page=1
////fun getAllData():Call<List<Property>>
////    fun getAllData(P):Call<List<Property>>
//
////
////object Api {
//////    val retroServices: APIServices  { retrofit.create(APIServices::class.java) }
////
////}