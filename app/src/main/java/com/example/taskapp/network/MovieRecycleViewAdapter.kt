package com.example.taskapp.network

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskapp.R
import com.example.taskapp.models.MovieModel
import com.squareup.picasso.Picasso

class MovieRecycleViewAdapter (private var movieList:List<MovieModel.Item>,private val context:Context): RecyclerView.Adapter<MovieRecycleViewAdapter.MoviesRecycleViewHolder>(){

    class MoviesRecycleViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView){
        var movieImage:ImageView = itemView.findViewById(R.id.movie_img)
        var releaseYear:TextView = itemView.findViewById(R.id.release_year_txt)
        var movieTitle:TextView = itemView.findViewById(R.id.movie_name)
        var rateText:TextView = itemView.findViewById(R.id.rateText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesRecycleViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.movie_item_layout, parent, false)
        return MoviesRecycleViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesRecycleViewHolder, position: Int) {
        holder.movieTitle.setText(movieList[position].title)
        holder.releaseYear.text = movieList[position].year
        holder.rateText.text = "${movieList[position].imDbRating}/10 IMDb"
        Picasso.get().load(movieList[position].image).fit().into(holder.movieImage)
    }

    override fun getItemCount(): Int {
        return movieList.count()
    }
}