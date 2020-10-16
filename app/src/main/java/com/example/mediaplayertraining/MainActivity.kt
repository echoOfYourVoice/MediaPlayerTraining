package com.example.mediaplayertraining

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var mMediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val audio = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        mMediaPlayer = MediaPlayer.create(this, R.raw.song)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
                if (mMediaPlayer.isPlaying) {
                    button.text = "PLAY"
                    mMediaPlayer.pause()
                }
                else {
                    button.text = "STOP"
                    mMediaPlayer.start()
                }
        }

        val addVolumeButton = findViewById<Button>(R.id.add_volume)
        addVolumeButton.setOnClickListener {
            audio.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI)
        }

        val subtractVolumeButton = findViewById<Button>(R.id.subtract_volume)
        subtractVolumeButton.setOnClickListener {
            audio.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI)
        }

        val trackUpButton = findViewById<Button>(R.id.trackUp)
        trackUpButton.setOnClickListener {
            mMediaPlayer.seekTo(mMediaPlayer.currentPosition + 30000)
        }

        val trackDownButton = findViewById<Button>(R.id.trackDown)
        trackDownButton.setOnClickListener {
            mMediaPlayer.seekTo(mMediaPlayer.currentPosition -30000)
        }

    }

}
