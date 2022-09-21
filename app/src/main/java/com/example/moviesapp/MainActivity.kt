package com.example.moviesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerView)







        getMovieData {
            recyclerView.adapter = MovieAdapter(it)
        }
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = APIRetrofit.getInstance().create(APIServices::class.java)
        apiService.getNowPlayingMovies().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)

            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                val error = t.message
                println(error)
            }
        })
    }


}

