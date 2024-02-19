package com.coderbinotechworld.ballotunit

import android.content.Context
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RawRes
import com.coderbinotechworld.ballotunit.databinding.ActivityDetailsBinding
import com.coderbinotechworld.ballotunit.model.GlobalClass

class DetailsActivity : AppCompatActivity() {

    private lateinit var symbol: String

    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("symbol")) {
            symbol = intent.getStringExtra("symbol").toString()
        }

        binding.tvForSymbol.text = symbol

    }

    override fun onPause() {
        super.onPause()
        MainActivity.MediaPlayerManager.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        MainActivity.MediaPlayerManager.stop()
    }

//    override fun onPause() {
//        super.onPause()
//
//        GlobalClass().stopSound()
//    }

//    override fun onStop() {
//        super.onStop()
//        GlobalClass().stopSound()
//    }


}