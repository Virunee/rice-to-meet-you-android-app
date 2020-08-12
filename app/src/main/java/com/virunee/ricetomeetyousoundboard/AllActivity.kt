package com.virunee.ricetomeetyousoundboard

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.virunee.ricetomeetyousoundboard.R
import kotlinx.android.synthetic.main.activity_all.*


class AllActivity : AppCompatActivity() {

    private val mediaPlayer: MediaPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all)

        var sounds = ArrayList<Sound>()
        sounds.add(Sound("ning ah", "NING AH NING AH"))
        sounds.add(Sound("eat my p", "You are eating my pussy, boy"))
        sounds.add(Sound("careless whisper","careless whisper"))
        sounds.add(Sound("you make me feel special","you make me feel special"))
        sounds.add(Sound("airhorn","airhorn"))
        sounds.add(Sound("finish him","finish him"))
        sounds.add(Sound("marvin gaye","marvin gaye"))
        sounds.add(Sound("mongolia","mongolia"))
        sounds.add(Sound("lonely af","lonely af"))
        sounds.add(Sound("R2MU intro","R2MU intro"))
        sounds.add(Sound("R2MU sting","R2MU sting"))
        sounds.add(Sound("R2MU outro","R2MU outro"))

        val soundsAdapter = SoundAdapter(this, sounds, R.color.colorYellow)
        val soundView: ListView = list_view_all
        soundView.adapter = soundsAdapter

        soundView.setOnItemClickListener{ parent, view, position, id ->
            Toast.makeText(this, "Clicked item :"+" "+position,Toast.LENGTH_SHORT).show()
        }

    }
}