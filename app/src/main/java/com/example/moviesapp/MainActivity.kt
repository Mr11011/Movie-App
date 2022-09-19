package com.example.moviesapp

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    private lateinit var loadingBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView2 = findViewById(R.id.recyclerView2)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView2.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.setHasFixedSize(false)
        loadingBar = findViewById(R.id.loadingBar)


        getMovieData {
            recyclerView.adapter = MovieAdapter(it)
            recyclerView2.adapter=MovieAdapter(it)


        }
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = APIServices2.getInstance().create(APIServices::class.java)

        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                loadingBar.visibility = View.GONE
//                return callback(response.body()!!.movies)
                recyclerView.adapter=response.body()?.movies?.let{MovieAdapter(it)}

            apiService.getTopRatedList().enqueue(object :Callback<MovieResponse>{
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    loadingBar.visibility=View.GONE
                    recyclerView2.adapter=response.body()?.movies?.let { MovieAdapter(it) }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
            }



            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                val error = t.message
                println(error)
            }
        })
    }


}