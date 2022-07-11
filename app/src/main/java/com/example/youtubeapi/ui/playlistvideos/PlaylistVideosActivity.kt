package com.example.youtubeapi.ui.playlistvideos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.youtubeapi.R
import com.example.youtubeapi.extensions.showToast

class PlaylistVideosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist_videos)
        intent.getStringExtra("id")?.let { showToast(it) }
    }
}