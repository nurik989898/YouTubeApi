package com.example.youtubeapi.ui.playlistvideos
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapi.App
import com.example.youtubeapi.model.Playlist
import com.example.youtubeapi.model.playListitems
import com.example.youtubeapi.remote.Repository
import retrofit2.Response

class PlayListitemsViewModel(private val repository: Repository): ViewModel() {
    fun getPlaylistItems(playlistId: String): LiveData<Response<playListitems>>{
        return repository.getplayListItems(playlistId)
    }
}