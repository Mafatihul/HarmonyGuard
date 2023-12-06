package com.example.hateapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.hateapp.R

class LoginActivity : AppCompatActivity(), View.OnClickListener{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val btnMoveActivity: Button = findViewById(R.id.button2)
        btnMoveActivity.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button2 -> {
                val moveIntent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }

}