package com.example.hateapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.hateapp.R
import com.example.hateapp.ui.ResultActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.button3)
        btnMoveActivity.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button3 -> {
                val moveIntent = Intent(this@MainActivity, ResultActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }

}