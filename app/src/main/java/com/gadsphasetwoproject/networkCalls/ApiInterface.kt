package com.gadsphasetwoproject.networkCalls

import com.gadsphasetwoproject.model.User
import com.gadsphasetwoproject.model.UserModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {


    @GET("/api/hours")
    fun getLearnerHours(): Call<List<User>>

    @GET("/api/skilliq")
    fun getLearnersIq(): Call<List<User>>

    companion object {

        var BASE_URL = "https://gadsapi.herokuapp.com/"

        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}

