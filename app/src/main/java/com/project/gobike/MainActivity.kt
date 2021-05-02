package com.project.gobike

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

//The Login Page
class MainActivity : AppCompatActivity() {

    lateinit var loginEmail: EditText
    lateinit var loginPassword: EditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginEmail = findViewById(R.id.editTextEmail);
        loginPassword = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.submitLogin);
        val preferences = getSharedPreferences("DATA_USER", MODE_PRIVATE)

        loginButton.setOnClickListener(View.OnClickListener {
            val user = loginEmail.text.toString();
            val password = loginPassword.text.toString();
            val email = preferences.getString(loginEmail.text.toString(), null)
            val pass = preferences.getString(loginPassword.text.toString(), null)

            if(email == user && pass == password ){
                val editor = preferences.edit()
                editor.putString("display", user)
                editor.apply();

                val intent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Please enter with your Email and Password", Toast.LENGTH_LONG).show()
            }
        })

        findViewById<TextView>(R.id.textViewNewAccount).setOnClickListener{
            val intent = Intent(this@MainActivity, RegistrationActivity::class.java)
            startActivity(intent)
        }

    }
}