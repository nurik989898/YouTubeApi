package com.example.youtubeapi.ui.playList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapi.BuildConfig.API_KEY
import com.example.youtubeapi.core.Object
import com.example.youtubeapi.model.Playlist
import com.example.youtubeapi.remote.RetroFitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayListViewModel: ViewModel() {
    private val youTubeApi = RetroFitClient.provideRetrofit()
    fun getPlaylist(): LiveData<Playlist>{
        val data = MutableLiveData<Playlist>()

        youTubeApi.getPlaylists(Object.PART,Object.CHANNEL_ID,Object.MAX_RESULT,API_KEY)
            .enqueue(object :
            Callback<Playlist>{
                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                    if (response.isSuccessful && response.body() != null){
                        data.value = response.body()
                    }

                }

                override fun onFailure(call: Call<Playlist>, t: Throwable) {
                   Log.e("Error","onFailure: ${t.localizedMessage}")
                }

            })
        return data
    }
}