package com.virunee.ricetomeetyousoundboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        category_all.setOnClickListener {
            Intent(this, AllActivity::class.java).also {
                this.startActivity(it)
            }
        }

        category_nigel.setOnClickListener {
            Intent(this, NigelActivity::class.java).also {
                this.startActivity(it)
            }
        }

        category_evelyn.setOnClickListener {
            Intent(this, EvelynActivity::class.java).also {
                this.startActivity(it)
            }
        }
    }
}