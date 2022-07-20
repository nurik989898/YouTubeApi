package com.example.youtubeapi.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtubeapi.App
import com.example.youtubeapi.BuildConfig
import com.example.youtubeapi.core.Object
import com.example.youtubeapi.model.Playlist
import com.example.youtubeapi.model.playListitems
import com.example.youtubeapi.ui.playList.PlayListViewModel
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

class Repository {
    private  val youTubeApi = App.youTubeApi
    fun getPlaylist(): LiveData<Response<Playlist>> = liveData(Dispatchers.IO) {
        val response = youTubeApi.getPlaylists(
            Object.PART,
            Object.CHANNEL_ID,
            Object.MAX_RESULT,
            BuildConfig.API_KEY
        )
        emit(response)
    }
    fun getplayListItems(playlistId: String): LiveData<Response<playListitems>> =
        liveData (Dispatchers.IO){
            val response = youTubeApi.getPlaylistsItems(
                Object.PART,
                BuildConfig.API_KEY,
                Object.MAX_RESULT,
                playlistId
            )
            emit(response)
        }
}