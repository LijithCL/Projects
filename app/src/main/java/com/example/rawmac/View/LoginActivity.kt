package com.example.rawmac.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.rawmac.R
import com.example.rawmac.databinding.ActivityLoginBinding
import com.example.rawmac.viewModel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)

        val activityLoginActivity: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel.getUsers().observe(this, Observer { users ->
            Toast.makeText(this,"$users",Toast.LENGTH_SHORT).show()
        })
    }
}