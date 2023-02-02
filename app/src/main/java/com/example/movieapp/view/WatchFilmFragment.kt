package com.example.movieapp.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.movieapp.R
import com.example.movieapp.viewModel.WatchFilmViewModel
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import kotlinx.android.synthetic.main.fragment_watch_film.*


class WatchFilmFragment : Fragment() {

    var filmId=0
    var VIDEO_ID=""

    private lateinit var watchFilmViewModel:WatchFilmViewModel

    //istek atacağımız siteni apı key'idir
    val API_KEY="fba70e551d24fdc5babd3e7e382d2670"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_watch_film, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
             filmId=DetailFragmentArgs.fromBundle(it).filmId
        }

        watchFilmViewModel=ViewModelProviders.of(this).get(WatchFilmViewModel::class.java)
        watchFilmViewModel.getFilmVideos(filmId,API_KEY,"en-US")
        observeLiveData()

    }

    private fun observeLiveData(){
        //dikkat!!!livedata arka planda çalşıyor.
        watchFilmViewModel.filmVideo.observe(viewLifecycleOwner, Observer {filmVideos->
            filmVideos?.let {
                //burada ilk videonun keyini aldım.daha sonra bütün keyleri alarak Videoarın tamamını datail
                // fragmentta gösterecem.herhangi bir videoya bastıktan sonra watchfragmentına gidecek
                VIDEO_ID=it.results.get(0).key

                val intent=Intent(context,WatchFilmActivity::class.java)
                intent.putExtra("VIDEO_ID",VIDEO_ID)
                startActivity(intent)
            }

        })

    }





}