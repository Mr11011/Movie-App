package com.example.moviesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item.view.*


class MovieAdapter(
    private val movies: List<Movie>
) :
    RecyclerView.Adapter<MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = movies[position]
        holder.bind(currentMovie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}
///////////////////////////////////////////////////////////////////////////////


class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"


    fun bind(movie: Movie) {

        itemView.label.text = movie.title
        itemView.label.text = movie.title
        Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.image1)


    }

}