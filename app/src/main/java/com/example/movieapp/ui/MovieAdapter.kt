package com.example.movieapp.ui

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.domain.model.MarvelMovie
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.util.loadImage

class MovieAdapter(private val activity: Activity, private val onItemClickListener: ((String) -> Unit)) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var movieItems = listOf<Movie>()
        set(value) {
            notifyDataSetChanged()
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.list_item_movie, parent, false)
        return MovieViewHolder(layout, activity)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindData(movieItems[position]) {
            onItemClickListener.invoke(it)
        }
    }

    override fun getItemCount(): Int = movieItems.count()

    class MovieViewHolder(itemView: View, val activity: Activity) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.movieTitle)
        private val movieDirectorTextView: TextView = itemView.findViewById(R.id.movieDirector)
        private val movieYearTextView: TextView = itemView.findViewById(R.id.movieYear)
        private val moviePoster: ImageView = itemView.findViewById(R.id.posterImageView)

        fun bindData(movie: Movie, onItemClickListener: ((String) -> Unit)?) {
            movie as MarvelMovie
            titleTextView.text = movie.movieTitle
            movieDirectorTextView.text = movie.imdbID
            movieYearTextView.text = movie.year.toString()
            activity.loadImage(movie.poster, R.drawable.ic_launcher_background, moviePoster, false)
            itemView.setOnClickListener { onItemClickListener?.invoke(movie.imdbID) }
        }
    }
}