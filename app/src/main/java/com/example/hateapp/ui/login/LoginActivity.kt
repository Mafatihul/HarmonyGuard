package com.example.hateapp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.hateapp.R
import com.example.hateapp.databinding.ActivityLoginBinding
import com.example.hateapp.ui.home.MainActivity
import com.example.hateapp.ui.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.button1.setOnClickListener {
            val email = binding.EtEmail.text.toString()
            val pass = binding.EtPass.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val  intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "Please check your password and email and try again.\n".toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this, "Empty Fields Are not Allowed", Toast.LENGTH_SHORT).show()
            }
        }



    }

}
