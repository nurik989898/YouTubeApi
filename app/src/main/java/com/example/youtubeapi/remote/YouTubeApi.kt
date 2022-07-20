package com.example.youtubeapi.remote


import com.example.youtubeapi.model.Playlist
import com.example.youtubeapi.model.playListitems
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApi {
    @GET("playlists")
    suspend fun getPlaylists(
        @Query("part")part: String,
        @Query("channelId") channelId: String,
        @Query("maxResults")maxResult:String,
        @Query("key")apiKey:String,
    ): Response<Playlist>

    @GET("playlistItems")

    suspend fun getPlaylistsItems(
        @Query("part") part: String,
        @Query("key") apiKey: String,
        @Query("playlistId") playlistId: String,
        @Query("maxResults") maxResults: String,
    ): Response<playListitems>
}