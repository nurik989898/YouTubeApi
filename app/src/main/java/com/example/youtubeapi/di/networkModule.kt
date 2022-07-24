package com.example.youtubeapi.di

import com.example.youtubeapi.BuildConfig
import com.example.youtubeapi.remote.Repository
import com.example.youtubeapi.remote.YouTubeApi
import com.example.youtubeapi.ui.playlistvideos.PlayListitemsViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
single { provideRetrofit(get()) }
    factory { provideOkHttpClient() }
    single { provideApi(get()) }
}
fun provideRetrofit(okHttpClient: OkHttpClient)=
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build()
fun provideOkHttpClient(): OkHttpClient{
    val intercepter = HttpLoggingInterceptor()
    intercepter.setLevel(HttpLoggingInterceptor.Level.BODY)
    return OkHttpClient().newBuilder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(intercepter)
        .build()
}
fun provideApi(retrofit: Retrofit) = retrofit.create(YouTubeApi::class.java)