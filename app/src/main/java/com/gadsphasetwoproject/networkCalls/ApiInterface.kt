package com.gadsphasetwoproject.networkCalls

import com.gadsphasetwoproject.model.UserModel
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface ApiInterface {


    @GET("/api/hours")
    suspend fun getLearnerHours(): Response<UserModel>

    @GET("/api/skilliq")
    suspend fun getLearnersIq(): Response<UserModel>


    class ApiClient(client: OkHttpClient) {
        // Configure retrofit to parse JSON and use coroutines
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://gadsapi.herokuapp.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiInterface: ApiInterface = retrofit.create(ApiInterface::class.java)


    }

    object CreateUserClient {

        //TODO Handle time out error
        private val builder = OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .connectionPool(ConnectionPool(0, 5, TimeUnit.MINUTES))
            .protocols(listOf(Protocol.HTTP_1_1))

        //private val httpClientBuilder = OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)

        private val retrofit = Retrofit.Builder()
            .baseUrl("https://gadsapi.herokuapp.com/")
            .client(builder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiInterface: ApiInterface = retrofit.create(ApiInterface::class.java)

    }
}

