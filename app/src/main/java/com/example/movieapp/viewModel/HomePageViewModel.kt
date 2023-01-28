package com.example.movieapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.model.PopularFilm
import com.example.movieapp.model.PopularResults
import com.example.movieapp.service.MovieApiService
import kotlinx.coroutines.*

class HomePageViewModel: ViewModel() {

    val movieApiService=MovieApiService()
    val popularFilm= MutableLiveData<List<PopularFilm>>()
    val error=MutableLiveData<Boolean>()
    val loading=MutableLiveData<Boolean>()
    private lateinit var job:Job




    fun refreshData(){


    }
    fun getDataFromPopularFilm(api_key:String,language:String,page:Int){
        job=CoroutineScope(Dispatchers.IO).launch {
            val response=movieApiService.getPopularFilm(api_key,language,page)

            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    response.body()?.let {
                        popularFilm.value=it
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