package com.virunee.ricetomeetyousoundboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_all.*

class AllActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all)

        var sounds = ArrayList<String>()
        sounds.add("ning ah")
        sounds.add("eat my p")
        sounds.add("careless whisper")
        sounds.add("you make me feel special")
        sounds.add("airhorn")
        sounds.add("finish him")
        sounds.add("marvin gaye")
        sounds.add("mongolia")
        sounds.add("lonely af")
        sounds.add("R2MU intro")
        sounds.add("R2MU sting")
        sounds.add("R2MU outro")

        for(i in sounds) {
            val soundView = TextView(this)
            soundView.text = i
            root_view_all.addView(soundView)
        }

    }
}