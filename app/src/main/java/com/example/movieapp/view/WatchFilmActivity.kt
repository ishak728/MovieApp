package com.example.movieapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.movieapp.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class WatchFilmActivity : YouTubeBaseActivity() {

    var VIDEO_ID=""
    val YOUTUBE_API_KEY="AIzaSyDdgwLgT6I1H1LOvLLhCnPKGXZ_G0q_9Y0"
    private lateinit var btnPlay: Button
    private lateinit var youtubePlayer: YouTubePlayerView
    private lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_watch_film)
        youtubePlayer=findViewById(R.id.youtubePlayer)
        btnPlay=findViewById(R.id.btnPlayer)


        val intent=intent
        VIDEO_ID= intent.getStringExtra("VIDEO_ID").toString()

        youtubePlayerInit=object :YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                p1?.loadVideo(VIDEO_ID)
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Toast.makeText(this@WatchFilmActivity,"hata", Toast.LENGTH_LONG).show()
            }

        }
        btnPlay.setOnClickListener{
            youtubePlayer.initialize(YOUTUBE_API_KEY,youtubePlayerInit)
        }
    }
}