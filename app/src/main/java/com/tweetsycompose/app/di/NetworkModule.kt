package com.tweetsycompose.app.di

import com.tweetsycompose.app.api.TweetsyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl("https://api.jsonbin.io")
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }


    @Provides
    @Singleton
    fun providesTweetsyApi(retrofit: Retrofit): TweetsyApi {
        return retrofit.create(TweetsyApi::class.java)
    }


}