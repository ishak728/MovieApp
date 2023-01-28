package com.example.movieapp.service

import com.example.movieapp.model.PopularFilm
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MovieApiService {
    //baseUrl=https://api.themoviedb.org/3/movie/

    val POPULAR_MOVİE_BASE_URL="https://api.themoviedb.org/3/movie/"

        val popularMovieApi=Retrofit.Builder()
            .baseUrl(POPULAR_MOVİE_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)

    suspend fun getPopularFilm(api_key:String,language:String,page:Int):Response<List<PopularFilm>>{
//////
        return popularMovieApi.getPopularFilm(api_key,language,page)
    }



}