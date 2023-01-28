package com.example.movieapp.service

import com.example.movieapp.model.PopularFilm
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    //to get popular film=https://api.themoviedb.org/3/movie/popular?api_key=<<api_key>>&language=en-US&page=1

    //baseUrl=https://api.themoviedb.org/3/movie/
    //endoint=popular


@GET("popular")
suspend fun getPopularFilm(@Query("api_key") api_key:String,
                   @Query("language") language:String,
                   @Query("page") page:Int):Response<List<PopularFilm>>




}