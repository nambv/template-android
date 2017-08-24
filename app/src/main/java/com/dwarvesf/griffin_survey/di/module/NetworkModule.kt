package com.dwarvesf.griffin_survey.di.module

import android.app.Application
import android.content.SharedPreferences
import com.dwarvesf.griffin_survey.R
import com.dwarvesf.griffin_survey.service.ApiEndPoint
import com.dwarvesf.griffin_survey.service.NetworkService
import com.dwarvesf.griffin_survey.util.Constant
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl(ApiEndPoint.STAGING_API)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient)
                .build()
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
                .setDateFormat(Constant.DATE_FORMAT)
                .create()
    }

    @Provides
    fun provideOkHttp(application: Application, sharedReference: SharedPreferences): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()

        return httpClient
                .addInterceptor { chain ->
                    val original = chain.request()
                    val request = original.newBuilder()
                            .header("Authorization", "Bearer " + sharedReference.getString(application.getString(R.string.key_user_access_token), ""))
                            .method(original.method(), original.body())
                            .build()

                    chain.proceed(request)
                }
                .addInterceptor(loggingInterceptor)
                .build()
    }

    @Provides
    @Singleton
    fun provideNetworkService(retrofit: Retrofit): NetworkService = retrofit.create(NetworkService::class.java)
}
