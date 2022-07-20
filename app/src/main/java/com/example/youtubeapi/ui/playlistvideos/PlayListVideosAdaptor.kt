package com.example.youtubeapi.ui.playlistvideos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi.databinding.ItemsFileBinding
import com.example.youtubeapi.extensions.load
import com.example.youtubeapi.model.Items

class PlayListVideosAdaptor(private var videos:ArrayList<Items>):
    RecyclerView.Adapter<PlayListVideosAdaptor.VideosViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosViewHolder {
        return VideosViewHolder(ItemsFileBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        )
    }


    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {
    holder.onBind(videos[position])
    }

    override fun getItemCount()= videos.size

      inner  class VideosViewHolder(private val binding: ItemsFileBinding):
    RecyclerView.ViewHolder(binding.root) {
            fun onBind(items: Items) {
               binding.ivVideo.load(items.snippet.thumbnails.medium.url)
                binding.tvVideoTitle.text = items.snippet.title
                binding.tvVideoTit.text = items.contentDetails.videoPublishedAt
            }
        }
}
