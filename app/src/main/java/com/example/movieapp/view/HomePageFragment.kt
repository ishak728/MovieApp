package com.example.movieapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.movieapp.R
import com.example.movieapp.adapter.MainAdapter
import com.example.movieapp.adapter.PopularFilmAdapter
import com.example.movieapp.model.PopularResults
import com.example.movieapp.viewModel.HomePageViewModel
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class HomePageFragment : Fragment() {

    val arrarrayList=ArrayList<ArrayList<PopularResults>>()

    private lateinit var viewModel:HomePageViewModel
    val API_KEY="fba70e551d24fdc5babd3e7e382d2670"

    var popularFilmAdapter=PopularFilmAdapter(arrayListOf())
    var topRatedFilmAdapter=PopularFilmAdapter(arrayListOf())
    var nowPlayingFilmAdapter=PopularFilmAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =ViewModelProviders.of(this).get(HomePageViewModel::class.java)

        showData()
    }

    fun showData(){


        val job=runBlocking {
            launch {
                arrarrayList.add(popularFilm())
                arrarrayList.add(topRatedFilm())
                arrarrayList.add(nowPlayingFilm())
                println("59595959:size arrarraylist:::"+arrarrayList.size)
            }
        }


        if(job.isCompleted){
            println("--------------arrasdysad"+arrarrayList.size)

            parentRecyclerView.adapter=MainAdapter(arrarrayList)
        }

    }

    fun popularFilm(): ArrayList<PopularResults> {
        val arrayList = ArrayList<PopularResults>()

        viewModel.getDataFromPopularFilm(API_KEY, "en-US", 1)

        viewModel.popularFilm.observe(viewLifecycleOwner, Observer { popularFilmList ->
            arrayList.addAll(popularFilmList.get(0).results)
        })

        return arrayList

    }

    fun topRatedFilm(): ArrayList<PopularResults> {
        val arrayList = ArrayList<PopularResults>()

        viewModel.getDataFromTopRatedFilm(API_KEY,"en-US",1)

        viewModel.topRatedFilm.observe(viewLifecycleOwner, Observer {topRatedFilmList->

            arrayList.addAll(topRatedFilmList.get(0).results)
        })
        return arrayList
    }
    fun nowPlayingFilm(): ArrayList<PopularResults> {
        val arrayList = ArrayList<PopularResults>()

        viewModel.getDataFromNowPlayinFilm(API_KEY,"en-US",1)

        viewModel.nowPlayingFilm.observe(viewLifecycleOwner, Observer {nowPlayingFilmList->
            arrayList.addAll(nowPlayingFilmList.get(0).results)

        })
        return arrayList
    }

}

