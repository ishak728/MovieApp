package com.example.movieapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.adapter.PopularFilmAdapter
import com.example.movieapp.model.PopularFilm
import com.example.movieapp.model.PopularResults
import com.example.movieapp.viewModel.HomePageViewModel
import kotlinx.android.synthetic.main.fragment_home_page.*

class HomePageFragment : Fragment() {
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
        popularFilm()
        topRatedFilm()
        nowPlayingFilm()

    }

    fun popularFilm(){
        popularFilmRecyclerView.adapter=popularFilmAdapter
        popularFilmRecyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        viewModel.getDataFromPopularFilm(API_KEY,"en-US",1)

        viewModel.popularFilm.observe(viewLifecycleOwner, Observer {popularFilmList->
            popularFilmAdapter.updatePopularFilmList(popularFilmList.get(0).results as ArrayList<PopularResults>)

        })
    }

    fun topRatedFilm(){
        topRatedFilmRecyclerView.adapter=topRatedFilmAdapter
        topRatedFilmRecyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        viewModel.getDataFromTopRatedFilm(API_KEY,"en-US",1)

        viewModel.topRatedFilm.observe(viewLifecycleOwner, Observer {topRatedFilmList->
            topRatedFilmAdapter.updatePopularFilmList(topRatedFilmList.get(0).results as ArrayList<PopularResults>)

        })
    }
    fun nowPlayingFilm(){
        nowPlayingFilmRecyclerView.adapter=nowPlayingFilmAdapter
        nowPlayingFilmRecyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        viewModel.getDataFromNowPlayinFilm(API_KEY,"en-US",1)

        viewModel.nowPlayingFilm.observe(viewLifecycleOwner, Observer {nowPlayingFilmList->
            nowPlayingFilmAdapter.updatePopularFilmList(nowPlayingFilmList.get(0).results as ArrayList<PopularResults>)

        })
    }
}

