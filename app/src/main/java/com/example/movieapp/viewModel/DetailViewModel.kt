package com.example.movieapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.model.DetailFilm
import com.example.movieapp.model.PopularFilm
import com.example.movieapp.service.MovieApiService
import kotlinx.coroutines.*

class DetailViewModel:ViewModel() {

    val detailFilm=MutableLiveData<DetailFilm>()
    val movieApiService= MovieApiService()
    private lateinit var job:Job



    fun getDetailFilm(movieId:Int,api_key:String,language:String){


        job=CoroutineScope(Dispatchers.IO).launch {
            val response=movieApiService.getDataFilm(movieId,api_key,language)
            withContext(Dispatchers.Main){

                if(response.isSuccessful){
                    response.body()?.let {
                        detailFilm.value= it

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