package com.example.movieapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.model.PopularFilm
import com.example.movieapp.model.PopularResults
import com.example.movieapp.service.MovieApiService
import kotlinx.coroutines.*

class HomePageViewModel: ViewModel() {

    val movieApiService=MovieApiService()

    val error=MutableLiveData<Boolean>()
    val loading=MutableLiveData<Boolean>()
    private lateinit var jobPopularFilm:Job
    private lateinit var jobTopRatedFilm:Job
    private lateinit var jobNowPlayingFilm:Job
    val popularFilm= MutableLiveData<List<PopularFilm>>()
    val topRatedFilm= MutableLiveData<List<PopularFilm>>()
    val nowPlayingFilm= MutableLiveData<List<PopularFilm>>()




    fun refreshData(){


    }
    fun getDataFromPopularFilm(api_key:String,language:String,page:Int){
        jobPopularFilm=CoroutineScope(Dispatchers.IO).launch {
            val response=movieApiService.getPopularFilm(api_key,language,page)

            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    response.body()?.let {
                        popularFilm.value= arrayListOf(it)
                    }
                    error.value=false
                    loading.value=false
                }
                else{//coroutinede hata oluşumu nasıl tespit edilir öğren
                    loading.value=true
                }
            }
        }

    }

    fun getDataFromTopRatedFilm(api_key:String,language:String,page:Int){
        jobTopRatedFilm=CoroutineScope(Dispatchers.IO).launch {
            val response=movieApiService.getTopRatedFilm(api_key,language,page)

            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    response.body()?.let {
                        topRatedFilm.value= arrayListOf(it)
                    }
                    error.value=false
                    loading.value=false
                }
                else{//coroutinede hata oluşumu nasıl tespit edilir öğren
                    loading.value=true
                }
            }
        }

    }

    fun getDataFromNowPlayinFilm(api_key:String,language:String,page:Int){
        jobNowPlayingFilm=CoroutineScope(Dispatchers.IO).launch {
            val response=movieApiService.getNowPlayingFilm(api_key,language,page)

            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    response.body()?.let {
                        nowPlayingFilm.value= arrayListOf(it)
                    }
                    error.value=false
                    loading.value=false
                }
                else{//coroutinede hata oluşumu nasıl tespit edilir öğren
                    loading.value=true
                }
            }
        }

    }
}