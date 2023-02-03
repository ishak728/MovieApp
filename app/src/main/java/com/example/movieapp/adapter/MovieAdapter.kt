package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.model.PopularResults
import com.example.movieapp.util.downloadImage
import kotlinx.android.synthetic.main.item_film.view.*

class MovieAdapter(val arrayList:ArrayList<PopularResults>):RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    class MovieHolder(val view:View):RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
       val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_film,parent,false)
        return MovieHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.view.filmImage.downloadImage(arrayList.get(position).poster_path)
    }

}