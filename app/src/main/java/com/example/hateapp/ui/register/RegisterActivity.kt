package com.example.hateapp.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hateapp.R
import com.example.hateapp.databinding.ActivityRegisterBinding
import com.example.hateapp.ui.home.MainActivity
import com.example.hateapp.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.button1.setOnClickListener {
            val email = binding.EtEmail2.text.toString()
            val pass = binding.EtPass2.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed", Toast.LENGTH_SHORT).show()
            }
        }

    }
}