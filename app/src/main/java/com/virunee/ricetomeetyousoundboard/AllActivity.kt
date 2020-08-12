package com.virunee.ricetomeetyousoundboard

import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_all.*


class AllActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all)

        var sounds = ArrayList<Sound>()
        sounds.add(Sound("ning ah", "NING AH NING AH", R.raw.ning_ah))
        sounds.add(Sound("eat my p", "You are eating my pussy, boy", R.raw.eat_my_p))
        sounds.add(Sound("careless whisper","careless whisper", R.raw.careless_whisper))
        sounds.add(Sound("you make me feel special","you make me feel special", R.raw.special))
        sounds.add(Sound("airhorn","airhorn", R.raw.airhorn))
        sounds.add(Sound("finish him","finish him", R.raw.finish_him))
        sounds.add(Sound("marvin gaye","marvin gaye", R.raw.marvin_gaye))
        sounds.add(Sound("mongolia","mongolia", R.raw.mongolia))
        sounds.add(Sound("lonely af","lonely af", R.raw.lonely_af))
        sounds.add(Sound("R2MU intro","R2MU intro", R.raw.r2mu_intro))
        sounds.add(Sound("R2MU sting","R2MU sting", R.raw.r2mu_sting))
        sounds.add(Sound("R2MU outro","R2MU outro", R.raw.r2mu_outro))

        val soundsAdapter = SoundAdapter(this, sounds, R.color.colorYellow)
        val soundView: ListView = list_view_all
        soundView.adapter = soundsAdapter

        soundView.setOnItemClickListener{ parent, view, position, id ->
            releaseMediaPlayer()
            mediaPlayer = MediaPlayer.create(this, sounds.get(position).getAudioResource())
            mediaPlayer?.start()
            mediaPlayer?.setOnCompletionListener(completionListener)
        }
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private var completionListener: OnCompletionListener? =
        OnCompletionListener { // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer()
        }

    fun releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer?.release();
            mediaPlayer = null
        }
    }
}