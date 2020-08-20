package com.virunee.ricetomeetyousoundboard

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.sounds_list.*

class NigelActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    private lateinit var audioManager: AudioManager

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sounds_list)

        var sounds = ArrayList<Sound>()
        sounds.add(Sound("eat my p", "You are eating my pussy, boy", R.raw.eat_my_p))
        sounds.add(Sound("No noooo","No noooo!", R.raw.nigel_no_noooo))
        sounds.add(Sound("Stop improving","Stop improving yourself", R.raw.nigel_stop_improving_yourself))
        sounds.add(Sound("Why like this","Haiyaa, why you like this?", R.raw.nigel_why_like_this))

        val soundsAdapter = SoundAdapter(this, sounds, R.color.colorYellow)
        val soundView: ListView = list_view_all
        soundView.adapter = soundsAdapter

        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager

        // Request audio focus so in order to play the audio file. The app needs to play a
        // short audio file, so we will request audio focus with a short amount of time
        // with AUDIOFOCUS_GAIN_TRANSIENT.
        val focusRequest = AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN).run{
            setAudioAttributes(AudioAttributes.Builder().run {
                setUsage(AudioAttributes.USAGE_MEDIA)
                setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                build()
            })
            setOnAudioFocusChangeListener(onAudioFocusChangeListener)
            build()
        }

        soundView.setOnItemClickListener{ parent, view, position, id ->
            releaseMediaPlayer()

            // Request audio focus so in order to play the audio file. The app needs to play a
            // short audio file, so we will request audio focus with a short amount of time
            // with AUDIOFOCUS_GAIN_TRANSIENT.
            val result = audioManager.requestAudioFocus(focusRequest)
            if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                // We have audio focus now

                // Create and setup the Media Player for the audio resource associate with the current word
                mediaPlayer = MediaPlayer.create(this, sounds[position].getAudioResource())

                // Start the audio file
                mediaPlayer?.start()

                // Set up the onCompletionListener on the media player so we can stop and release the player once the audio has finished playing.
                mediaPlayer?.setOnCompletionListener(completionListener)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        releaseMediaPlayer()
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private var completionListener: MediaPlayer.OnCompletionListener? =
        MediaPlayer.OnCompletionListener { // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer()
        }

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private var onAudioFocusChangeListener: AudioManager.OnAudioFocusChangeListener = AudioManager.OnAudioFocusChangeListener { focusChange ->
        if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
            // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
            // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
            // our app is allowed to continue playing sound but at a lower volume. We'll treat
            // both cases the same way because our app is playing short sound files.

            // Pause playback and reset player to the start of the file. That way, we can
            // play the word from the beginning when we resume playback.
            mediaPlayer?.pause();
//            mediaPlayer?.seekTo(0);
        } else if(focusChange == AudioManager.AUDIOFOCUS_GAIN) {
            // We've regained focus and can resume playing.
            mediaPlayer?.start()
        } else if(focusChange == AudioManager.AUDIOFOCUS_LOSS) {
            // The AUDIOFOCUS_LOSS case means we've lost audio focus and
            // Stop playback and clean up resources
            mediaPlayer?.stop()
            releaseMediaPlayer()
        }
    }

    private fun releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer?.release();
            mediaPlayer = null

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            audioManager.abandonAudioFocus(onAudioFocusChangeListener)
        }
    }
}