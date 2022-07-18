package com.example.youtubeapi.ui.playList
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapi.App
import com.example.youtubeapi.model.Playlist
import retrofit2.Response

class PlayListViewModel: ViewModel() {
    fun getPlaylist(): LiveData<Response<Playlist>>{
        return App.repository.getPlaylist()
    }
}