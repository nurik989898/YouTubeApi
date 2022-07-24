package com.example.youtubeapi.ui.playList
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapi.model.Playlist
import com.example.youtubeapi.remote.Repository
import retrofit2.Response

class PlayListViewModel(private val repository: Repository): ViewModel() {
    fun getPlaylist(): LiveData<Response<Playlist>>{
        return repository.getPlaylist()
    }
}