//21565 - Alessandra Reis // 21913 - Taiane Vieira da Silva // 21789 - Yuri Filipe Almeida Silva

package com.project.gobike

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

//The Login Page
class LoginActivity : AppCompatActivity() {

    lateinit var loginEmail: EditText
    lateinit var loginPassword: EditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_GoBike)
        setContentView(R.layout.activity_login)

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

                val intent = Intent(this@LoginActivity, CityActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Please enter with your Email and Password", Toast.LENGTH_LONG).show()
            }
        })

        findViewById<TextView>(R.id.textViewNewAccount).setOnClickListener{
            val intent = Intent(this@LoginActivity, RegistrationActivity::class.java)
            startActivity(intent)
        }

    }
}