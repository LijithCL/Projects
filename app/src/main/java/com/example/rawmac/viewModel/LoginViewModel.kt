package com.example.rawmac.viewModel

import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rawmac.Model.Model
import com.example.rawmac.Repository.LoginRepository


class LoginViewModel(private val loginRepository: LoginRepository) :ViewModel() {

    private val users = MutableLiveData<String>()
    private val model: Model
//    private val int:Int=0

    private val errorMessage = "Email or Password is not valid"

    init {

        model = Model("", "")
    }

    @get:Bindable
    var txt_LoginEmail: String?
        get() = model.email
        set(email) {
            model.email = email
//            notifyPropertyChanged(BR.txt_LoginEmail)
        }

    // getter and setter methods
    // for password variable
    @get:Bindable
    var txt_LoginPassword: String?
        get() = model.password
        set(password) {
            model.password = password
//            notifyPropertyChanged(BR.txt_LoginPassword)
        }

    fun onButtonClicked() {
        if (isValid)
            txt_LoginEmail?.let { txt_LoginPassword?.let { it1 -> fetchUsers(it, it1) } }
        else
            Log.e("error message",errorMessage)
    }

    val isValid: Boolean
        get() = (!TextUtils.isEmpty(txt_LoginEmail) && Patterns.EMAIL_ADDRESS.matcher(txt_LoginEmail).matches() && txt_LoginPassword!!.length > 5)


    private fun fetchUsers(txt_LoginEmail:String,txt_LoginPassword:String) {
//        loginRepository.getUser(txt_LoginEmail,txt_LoginPassword)

        users.postValue(loginRepository.getUser(txt_LoginEmail,txt_LoginPassword))

    }

    fun getUsers(): MutableLiveData<String> {
        return users
    }

    fun onPasswordToggle(){

    }

}

