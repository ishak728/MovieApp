package com.example.movieapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.movieapp.R
import com.example.movieapp.util.downloadImage
import com.example.movieapp.viewModel.DetailViewModel
import com.example.movieapp.viewModel.HomePageViewModel
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {

    var filmId=0
    val API_KEY="fba70e551d24fdc5babd3e7e382d2670"
    private lateinit var viewModel:DetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProviders.of(this).get(DetailViewModel::class.java)

        arguments?.let {
            println("detailfrag.::38")
            filmId=DetailFragmentArgs.fromBundle(it).filmId
            observeDetailFilmLiveData(filmId)
        }

        watchFilmButton.setOnClickListener{
            val action=DetailFragmentDirections.actionDetailFragmentToWatchFilmFragment(filmId)
            it.findNavController().navigate(action)
        }
    }


    fun observeDetailFilmLiveData(film_id:Int){


        viewModel.getDetailFilm(film_id,API_KEY,"en-US")
        viewModel.detailFilm.observe(viewLifecycleOwner, Observer {   detailFilm->


            detailFilm?.let {

                overviewText.text=it.overview

                it.backdrop_path?.let { it1 -> detailFragmentImageView.downloadImage(it1)

                }
            }

        })


    }
}