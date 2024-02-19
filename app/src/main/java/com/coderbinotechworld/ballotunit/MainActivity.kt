package com.coderbinotechworld.ballotunit

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RawRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.coderbinotechworld.ballotunit.adapter.VotingAdapter
import com.coderbinotechworld.ballotunit.databinding.ActivityMainBinding
import com.coderbinotechworld.ballotunit.model.GlobalClass
import com.coderbinotechworld.ballotunit.model.ItemForVoting

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var itemList: ArrayList<ItemForVoting>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemList = arrayListOf()

        itemList.add(ItemForVoting(
            sNo = 1,
            name = "AAA",
            symbol = "α"
        ))
        itemList.add(ItemForVoting(
            sNo = 2,
            name = "BBB",
            symbol = "β"
        ))
        itemList.add(ItemForVoting(
            sNo = 3,
            name = "CCC",
            symbol = "χ"
        ))
        itemList.add(ItemForVoting(
            sNo = 4,
            name = "DDD",
            symbol = "δ"
        ))
        itemList.add(ItemForVoting(
            sNo = 5,
            name = "EEE",
            symbol = "ε"
        ))
        itemList.add(ItemForVoting(
            sNo = 6,
            name = "FFF",
            symbol = "Φ"
        ))
        itemList.add(ItemForVoting(
            sNo = 7,
            name = "GGG",
            symbol = "γ"
        ))
        itemList.add(ItemForVoting(
            sNo = 8,
            name = "HHH",
            symbol = "η"
        ))
        itemList.add(ItemForVoting(
            sNo = 9,
            name = "III",
            symbol = "ι"
        ))
        itemList.add(ItemForVoting(
            sNo = 10,
            name = "JJJ",
            symbol = "φ"
        ))
        itemList.add(ItemForVoting(
            sNo = 11,
            name = "KKK",
            symbol = "κ"
        ))
        itemList.add(ItemForVoting(
            sNo = 12,
            name = "LLL",
            symbol = "λ"
        ))
        itemList.add(ItemForVoting(
            sNo = 13,
            name = "MMM",
            symbol = "μ"
        ))
        itemList.add(ItemForVoting(
            sNo = 14,
            name = "NNN",
            symbol = "ν"
        ))
        itemList.add(ItemForVoting(
            sNo = 15,
            name = "OOO",
            symbol = "ο"
        ))
        itemList.add(ItemForVoting(
            sNo = 16,
            name = "None of The Above",
            symbol = "X"
        ))

        val adapter = VotingAdapter(this, itemList)

        binding.rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rv.adapter = adapter

        adapter.setOnClickListener(object : VotingAdapter.OnClickListener{
            override fun onClick(position: Int, symbol: String) {

                MediaPlayerManager.initialize(this@MainActivity, R.raw.bip)
                MediaPlayerManager.start()

                val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                intent.putExtra("symbol", symbol)
                startActivity(intent)

            }
        })

    }

    override fun onRestart() {
        super.onRestart()
        MediaPlayerManager.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        MediaPlayerManager.stop()
    }


    object MediaPlayerManager {
        private var mediaPlayer: MediaPlayer? = null

        fun initialize(context: Context, @RawRes audioResourceId: Int) {
            mediaPlayer = MediaPlayer.create(context, audioResourceId)
        }

        fun start() {
            mediaPlayer?.start()
        }

        fun pause() {
            mediaPlayer?.pause()
        }

        fun stop() {
            mediaPlayer?.stop()
        }

        fun release() {
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }
}