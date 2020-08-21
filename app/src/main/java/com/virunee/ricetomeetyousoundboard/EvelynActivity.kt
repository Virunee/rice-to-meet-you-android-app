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

class EvelynActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all)
        supportFragmentManager.beginTransaction().replace(R.id.container, EvelynFragment()).commit()
    }
}