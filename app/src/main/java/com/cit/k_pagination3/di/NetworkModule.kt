package com.cit.k_pagination3.di

import com.cit.k_pagination3.api.QuotesApi
import com.cit.k_pagination3.utils.Constantns
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getRetrofitBuilder(): Retrofit.Builder{
        return Retrofit.Builder().baseUrl(Constantns.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun  getQuoteApi( retrofit: Retrofit.Builder): QuotesApi{
        return retrofit.build().create(QuotesApi::class.java)
    }





}