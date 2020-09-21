package com.gadsphasetwoproject.networkCalls

import com.gadsphasetwoproject.model.User
import com.gadsphasetwoproject.model.UserIq
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiInterface {


    /* @GET("/api/hours")
     fun getLearnerHours(): Call<List<User>>

     @GET("/api/skilliq")
     fun getLearnersIq(): Call<List<UserIq>>*/

    @GET("/api/hours")
    suspend fun getLearnerHours(): Response<List<User>>

    @GET("/api/skilliq")
    suspend fun getLearnersIq(): Response<List<UserIq>>

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun submitProject(
        @Field("entry.1824927963") email: String?,
        @Field("entry.1877115667") name: String?,
        @Field("entry.2006916086") lastName: String?,
        @Field("entry.284483984") link: String?
    ): Call<Void>

}

