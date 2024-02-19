package com.coderbinotechworld.ballotunit.model

import android.content.Context
import android.media.MediaPlayer
import com.coderbinotechworld.ballotunit.R

class GlobalClass {
    var bipSound: MediaPlayer? = null

    fun startSound(context: Context) {

        if (bipSound == null) {
            bipSound = MediaPlayer.create(context, R.raw.bip)
            bipSound?.start()
        }
    }

    fun stopSound() {
        if (bipSound != null) {
            bipSound!!.stop()
            bipSound!!.release()
            bipSound = null
        }
    }
}