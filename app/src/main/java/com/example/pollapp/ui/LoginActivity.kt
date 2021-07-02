package com.example.pollapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.pollapp.MainActivity
import com.example.pollapp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
        //setea el layout
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            validateData()
        }
    }
    private fun validateData() {
        val email = txt_email.text
        if (!txt_email.text.isNullOrBlank() && !txt_password.text.isNullOrBlank()) {
            // La Intent describe la actividad que se debe iniciar y contiene los datos necesarios para ello.
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("data","Email Logeado $email")
            startActivity(intent)
        } else {
            Toast.makeText(this, "Completar todos los campos", Toast.LENGTH_LONG).show()
        }
    }
}