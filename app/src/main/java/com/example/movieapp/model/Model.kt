package com.example.movieapp.model

import com.google.gson.annotations.SerializedName


//topRatedFilm ve nowPlayingFilm popularFilm modeliyle aynı olduğu için ayrı modeller oluşturmaya gerek duymadım
data class PopularFilm(
    val page: Int,
    val results: List<PopularResults>,
    val total_results:Int,
    val total_pages:Int
    )

data class PopularResults(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)


data class DetailFilm(
    val backdrop_path: String?,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String?,
    val release_date: String,
    val revenue: Long,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
) {
    data class Genre(
        val id: Int,
        val name: String
    )


}



data class FilmVideos(
    val id: Int,
    val results: List<Result>
) {
    data class Result(
        val iso_639_1: String,
        val iso_3166_1: String,
        val name: String,
        val key: String,
        val site: String,
        val size: Int,
        val type: String,
        val official: Boolean,
        val published_at: String,
        val id: String
    )
}


