package com.example.movieapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.model.DetailFilm
import com.example.movieapp.model.FilmVideos
import com.example.movieapp.service.MovieApiService
import kotlinx.coroutines.*

class WatchFilmViewModel: ViewModel() {
    val filmVideo= MutableLiveData<FilmVideos>()
    val movieApiService= MovieApiService()
    private lateinit var job: Job


    fun getFilmVideos(movieId:Int,api_key:String,language:String){


        job= CoroutineScope(Dispatchers.IO).launch {
            val response=movieApiService.getFilmVideo(movieId,api_key,language)
            withContext(Dispatchers.Main){

                if(response.isSuccessful){
                    response.body()?.let {
                        filmVideo.value= it

                    }
                }
                else{
                    //hata durumlarında veya yüklenme durumunda loading işlemeri yapılmalıdır
                    println("hata varrrrrrrrrrrrrrrrrrrrrr")
                }
            }
        }
    }
}