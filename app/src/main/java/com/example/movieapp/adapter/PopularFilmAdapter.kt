package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.model.PopularFilm
import com.example.movieapp.model.PopularResults
import com.example.movieapp.util.downloadImage
import com.example.movieapp.view.HomePageFragmentDirections
import kotlinx.android.synthetic.main.item_film.view.*

class PopularFilmAdapter(val popularFilmList:ArrayList<PopularResults>): RecyclerView.Adapter<PopularFilmAdapter.PopularFilmViewolder>() {

    class PopularFilmViewolder(val view:View):RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularFilmViewolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_film,parent,false)
        return PopularFilmViewolder(view)
    }

    override fun getItemCount(): Int {
        return popularFilmList.size
    }

    override fun onBindViewHolder(holder: PopularFilmViewolder, position: Int) {
        holder.view.filmName.text=popularFilmList.get(position).original_title
        holder.view.filmImage.downloadImage(popularFilmList.get(position).backdrop_path)
        holder.view.setOnClickListener{

            println("(((((((((((((((((((((("+popularFilmList.get(position).id+"))))))))))))))))))")
            val action=HomePageFragmentDirections.actionHomePageFragmentToDetailFragment(popularFilmList.get(position).id)
            Navigation.findNavController(it).navigate(action)
        }

    }

    fun updatePopularFilmList(newPopularFilmList:ArrayList<PopularResults>){
        popularFilmList.clear()
        popularFilmList.addAll(newPopularFilmList)
        notifyDataSetChanged()
    }
}