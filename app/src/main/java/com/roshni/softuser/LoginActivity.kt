package com.roshni.softuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etUsername = findViewById(R.id.etusername)
        etPassword = findViewById(R.id.etpassword)
        btnLogin = findViewById(R.id.btnlogin)

        btnLogin.setOnClickListener {
            if (validateInput()) {
                val username = etUsername.getText().toString()
                val password = etPassword.getText().toString()
                if (username == "softwarica" && password == "coventry") {
                    Toast.makeText(
                            this@LoginActivity,
                            "User Succesfully Logged in",
                            Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    etUsername.setText("");
                    etPassword.setText("");
                    etUsername.requestFocus()
                    Toast.makeText(this@LoginActivity, "Invalid Username or Password", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun validateInput(): Boolean {
        var result: Boolean = true
        when {
            TextUtils.isEmpty(etUsername.text) -> {
                etUsername.error = "This field should not be empty"
                etUsername.requestFocus()
                result = false
            }
            TextUtils.isEmpty(etPassword.text) -> {
                etPassword.error = "This field should not be empty"
                etPassword.requestFocus()
                result = false
            }
        }
        return result
    }
}
