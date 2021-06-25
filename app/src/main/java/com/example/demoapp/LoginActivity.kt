package com.example.demoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var userName: EditText
    private lateinit var passWord: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btnLogin: Button = findViewById(R.id.btn_login)
        userName = findViewById(R.id.edt_user_name)
        passWord = findViewById(R.id.edt_password)
        btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val bundle = Bundle()
            bundle.putString("username", userName.text.toString())
            bundle.putString("password", passWord.text.toString())
            intent.putExtra("BUNDLE", bundle)
            startActivity(intent)
        }
    }

}