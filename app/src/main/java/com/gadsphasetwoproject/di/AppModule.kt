package com.gadsphasetwoproject.di

import android.content.Context
import com.gadsphasetwoproject.networkCalls.ApiInterface
import com.gadsphasetwoproject.networkCalls.LearnerHoursRemoteDataSource
import com.gadsphasetwoproject.room.dao.LearningHoursDao
import com.gadsphasetwoproject.room.database.AppDatabase
import com.gadsphasetwoproject.room.repository.LearnerHoursRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun retrofit(gson: Gson):
            Retrofit = Retrofit.Builder()
        .baseUrl("https://gadsapi.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideLearnersHoursService(retrofit: Retrofit): ApiInterface =
        retrofit.create(ApiInterface::class.java)

    @Provides
    fun provideSkillIqService(retrofit: Retrofit): ApiInterface =
        retrofit.create(ApiInterface::class.java)

    @Singleton
    @Provides
    fun provideLearnersHoursRemoteDataSource(apiInterface: ApiInterface) =
        LearnerHoursRemoteDataSource(apiInterface)

    @Provides
    fun provideSkillIqRemoteDataSource(apiInterface: ApiInterface) =
        LearnerHoursRemoteDataSource(apiInterface)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)


    @Singleton
    @Provides
    fun provideLearnersHourDao(database: AppDatabase) = database.learningHoursDao()

    @Singleton
    @Provides
    fun provideSkillIqDao(database: AppDatabase) = database.skillIqDao()

    @Singleton
    @Provides
    fun provideLearnersHoursRepository(
        remoteDataSource: LearnerHoursRemoteDataSource,
        localDataSource: LearningHoursDao
    ) =
        LearnerHoursRepository(remoteDataSource, localDataSource)


/*    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun submitProject(
        @Field("entry.1824927963") email: String?,
        @Field("entry.1877115667") name: String?,
        @Field("entry.2006916086") lastName: String?,
        @Field("entry.284483984") link: String?
    ): Call<Void>

    companion object {

        var BASE_URL = "https://gadsapi.herokuapp.com/"
        var FORM_BASE_URL = "https://docs.google.com/forms/d/e/"

        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }

        fun submit(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(FORM_BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }*/
}