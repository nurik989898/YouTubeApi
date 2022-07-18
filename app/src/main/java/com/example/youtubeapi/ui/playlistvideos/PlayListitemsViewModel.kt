package com.example.youtubeapi.ui.playlistvideos
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapi.App
import com.example.youtubeapi.model.Playlist
import com.example.youtubeapi.model.playListitems
import retrofit2.Response

class PlayListitemsViewModel: ViewModel() {
    fun getPlaylistItems(playlistId: String): LiveData<Response<playListitems>>{
        return App.repository.getplayListItems(playlistId)
    }
}