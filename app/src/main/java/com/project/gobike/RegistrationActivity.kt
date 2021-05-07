//21565 - Alessandra Reis // 21913 - Taiane Vieira da Silva // 21789 - Yuri Filipe Almeida Silva

package com.project.gobike

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


//To register a new user
class RegistrationActivity : AppCompatActivity() {
    lateinit var registerName: EditText
    lateinit var registerDateOfBirth: EditText
    lateinit var registerEmail: EditText
    lateinit var registerPassword: EditText
    lateinit var saveButton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_GoBike)
        setContentView(R.layout.activity_registration)

        registerName = findViewById(R.id.editTextName);
        registerDateOfBirth = findViewById(R.id.editTextDate)
        registerEmail = findViewById(R.id.editTextEmailAddress)
        registerPassword = findViewById(R.id.editTextNewPassword)
        saveButton = findViewById(R.id.saveButton)
        val preferences = getSharedPreferences("DATA_USER", MODE_PRIVATE)

        saveButton.setOnClickListener(View.OnClickListener {
            val editor = preferences.edit()
            editor.putString(registerName.text.toString(), registerName.text.toString())
            editor.apply()
            editor.putString(registerDateOfBirth.text.toString(), registerDateOfBirth.text.toString())
            editor.apply()
            editor.putString(registerEmail.text.toString(), registerEmail.text.toString())
            editor.apply()
            editor.putString(registerPassword.text.toString(), registerPassword.text.toString())
            editor.apply()
            Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show()
            val intent = Intent(this@RegistrationActivity, LoginActivity::class.java)
            startActivity(intent)
        })
    }
}