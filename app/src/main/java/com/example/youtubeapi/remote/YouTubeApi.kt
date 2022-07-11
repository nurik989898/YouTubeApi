package com.example.youtubeapi.remote


import com.example.youtubeapi.model.Playlist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApi {
    @GET("playlists")
    fun getPlaylists(
        @Query("part")part: String,
        @Query("channelId") channelId: String,
        @Query("maxResult")maxResult:String,
        @Query("key")apiKey:String
    ): Call<Playlist>
}