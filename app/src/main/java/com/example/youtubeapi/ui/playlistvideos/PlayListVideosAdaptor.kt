package com.example.youtubeapi.ui.playlistvideos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi.databinding.PlaylistItemBinding
import com.example.youtubeapi.extensions.load
import com.example.youtubeapi.model.Items

class PlayListVideosAdaptor(private var videos:ArrayList<Items>):
    RecyclerView.Adapter<PlayListVideosAdaptor.VideosViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosViewHolder {
        return VideosViewHolder(PlaylistItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }


    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {
    holder.onBind(videos[position])
    }

    override fun getItemCount()= videos.size

        class VideosViewHolder(private val binding: PlaylistItemBinding):
    RecyclerView.ViewHolder(binding.root) {
            fun onBind(items: Items) {
               binding.ivPlaylist.load(items.snippet.thumbnails.medium.url)
                binding.tvVideoCounter.text = items.snippet.title
                binding.tvPlaylistTitle.text = items.contentDetails.videoPublishedAt
            }
        }
}
