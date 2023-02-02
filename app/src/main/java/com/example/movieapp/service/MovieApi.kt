package com.example.movieapp.service

import com.example.movieapp.model.DetailFilm
import com.example.movieapp.model.FilmVideos
import com.example.movieapp.model.PopularFilm
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    //to get popular film=https://api.themoviedb.org/3/movie/popular?api_key=<<api_key>>&language=en-US&page=1

    //baseUrl=https://api.themoviedb.org/3/movie/
    //endoint=popular


@GET("popular")
suspend fun getPopularFilm(@Query("api_key") api_key:String,
                   @Query("language") language:String,
                   @Query("page") page:Int):Response<PopularFilm>

    @GET("top_rated")
    suspend fun getTopRatedFilm(@Query("api_key") api_key:String,
                                @Query("language") language:String,
                                @Query("page") page:Int):Response<PopularFilm>
    @GET("now_playing")
    suspend fun getNowPlayingFilm(@Query("api_key") api_key:String,
                                @Query("language") language:String,
                                @Query("page") page:Int):Response<PopularFilm>

    @GET("{movie_id}")
    suspend fun getDetailFilm(@Path("movie_id") movieId:Int,
                               @Query("api_key") api_key:String,
                               @Query("language") language:String):Response<DetailFilm>

@GET("{movie_id}/videos")
suspend fun getFilmVideo(@Path("movie_id") movie_id:Int,
                         @Query("api_key") api_key:String,
                         @Query("language") language:String):Response<FilmVideos>


}