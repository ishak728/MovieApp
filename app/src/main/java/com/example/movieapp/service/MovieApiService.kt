package com.example.movieapp.service

import com.example.movieapp.model.DetailFilm
import com.example.movieapp.model.FilmVideos
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


    suspend fun getPopularFilm(api_key:String,language:String,page:Int):Response<PopularFilm>{

        return popularMovieApi.getPopularFilm(api_key,language,page)
    }
    suspend fun getTopRatedFilm(api_key:String,language:String,page:Int):Response<PopularFilm>{

        return popularMovieApi.getTopRatedFilm(api_key,language,page)
    }

    suspend fun getNowPlayingFilm(api_key:String,language:String,page:Int):Response<PopularFilm>{

        return popularMovieApi.getNowPlayingFilm(api_key,language,page)
    }

    suspend fun getDataFilm(movieId:Int,api_key:String,language:String):Response<DetailFilm>{

        return popularMovieApi.getDetailFilm(movieId,api_key,language)
    }


    suspend fun getFilmVideo(movieId:Int,api_key:String,language:String):Response<FilmVideos>{
        return popularMovieApi.getFilmVideo(movieId,api_key,language)
    }



}