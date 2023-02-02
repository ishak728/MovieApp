package com.example.movieapp.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movieapp.R

fun ImageView.downloadImage(url:String){

    val option=RequestOptions()
        .placeholder(placeHolderProgressbar(context))
        .error(R.mipmap.ic_launcher_round)

    Glide.with(context)
        .setDefaultRequestOptions(option)
        .load("https://image.tmdb.org/t/p/w500/${url}")
        .into(this)
}

fun placeHolderProgressbar(context:Context): CircularProgressDrawable {

    return CircularProgressDrawable(context).apply {
        strokeWidth=9f
        centerRadius=40f
        start()
    }
}