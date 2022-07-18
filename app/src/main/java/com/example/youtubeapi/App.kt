package com.example.youtubeapi

import android.app.Application
import com.example.youtubeapi.remote.Repository
import com.example.youtubeapi.remote.RetroFitClient

class App: Application() {
    companion object{
        val youTubeApi = RetroFitClient.provideRetrofit()
        val repository = Repository()
    }
}