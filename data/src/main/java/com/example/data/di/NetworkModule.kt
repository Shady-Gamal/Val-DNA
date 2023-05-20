package com.example.data.di

import com.example.data.repositoriesContracts.WebServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


   @Provides
   @Singleton
   fun provideConverterFactory() : GsonConverterFactory{
       return GsonConverterFactory.create()
   }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor{
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    @Provides
    @Singleton
    fun provideOkHTTP(loggingInterceptor: HttpLoggingInterceptor) : OkHttpClient{
        return OkHttpClient.Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory,
    okHttpClient: OkHttpClient) : Retrofit{
    return Retrofit
        .Builder()
        .baseUrl("https://valorant-api.com/v1/")
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .build()
    }

@Provides
@Singleton
    fun getWebServices(retrofit: Retrofit): WebServices{

        return retrofit.create(WebServices::class.java)
    }
}