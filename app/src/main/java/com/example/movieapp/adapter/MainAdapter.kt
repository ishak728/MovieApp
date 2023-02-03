package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.model.PopularResults
import kotlinx.android.synthetic.main.child_recycler_view.view.*
import kotlinx.android.synthetic.main.fragment_home_page.view.*

class MainAdapter(val arrayList:ArrayList<ArrayList<PopularResults>>):RecyclerView.Adapter<MainAdapter.MainHolder>() {
    class MainHolder(val view: View):RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.child_recycler_view,parent,false)
        return MainHolder(view)
    }

    override fun getItemCount(): Int {

        return arrayList.size
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {

       // holder.view.genreTextView.text="Popular"
        val movieAdapter= MovieAdapter(arrayList.get(position))
        holder.view.childRecyclerView.adapter=movieAdapter
    }

}