package com.example.rawmac.Repository

import android.util.Log
import com.example.rawmac.*
import retrofit2.Response

class LoginRepository {

    var loginData:String="token"
    fun getUser(email: String, password: String): String{

        val apibody = Apibody(email,password)
        var body = apibody
        var call = Retrofit.userApiInstance.getUsers(body)

        call.enqueue(object : retrofit2.Callback<Datas> {
            override fun onResponse(
                call: retrofit2.Call<Datas>,
                response: Response<Datas>
            ) {
                if (response.isSuccessful) {
                    loginData = response.body()!!.data.login_details.token


                }
            }

            override fun onFailure(call: retrofit2.Call<Datas>, t: Throwable) {
                Log.d("Network call failed", t.message.toString())
            }

        })
        return loginData
    }

}