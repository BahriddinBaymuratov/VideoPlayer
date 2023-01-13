package com.example.videoplayer

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.MediaController
import androidx.core.view.isVisible
import com.example.videoplayer.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var handler: Handler
    private val videoUrl =
        " https://firebasestorage.googleapis.com/v0/b/instagramclone-b53a9.appspot.com/o/video_2022-10-01_13-39-55.mp4?alt=media&token=44ae9041-c845-4c86-9c32-a02b837726e9"
//        "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        handler = Handler(mainLooper)

        // URL BILAN VIDEO KORSATISH UCHUN
//        val mediaController = MediaController(this)
//       binding.videoView.setVideoPath(videoUrl)
//        binding.videoView.setMediaController(mediaController)
//        mediaController.setAnchorView(binding.videoView)
//        binding.videoView.setOnPreparedListener {
//            binding.progressBar.isVisible = false
//            it.start()
//        }

        binding.btnPlay.setOnClickListener {
            if (mediaPlayer == null) {
                val mediaController = MediaController(this)
                val video = "android.resource://" + this.packageName + "/raw/" + R.raw.winter
                val videoUri = Uri.parse(video)
//                mediaPlayer = MediaPlayer.create(this, R.raw.video)
                handler.postDelayed(runnable, 100)
                mediaPlayer?.start()
                binding.videoView.setVideoURI(videoUri)
                binding.videoView.requestFocus()
                binding.videoView.start()
                binding.videoView.setMediaController(mediaController)
                mediaController.setAnchorView(binding.videoView)
            }
        }

        binding.videoView.setOnPreparedListener {
            binding.progressBar.isVisible = false
            it.start()
        }
    }

    private var runnable = object : Runnable {
        override fun run() {
            handler.postDelayed(this, 100)
            try {
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}