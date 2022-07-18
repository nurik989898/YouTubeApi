package com.example.youtubeapi.ui.playlistvideos
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi.core.BaseActivity
import com.example.youtubeapi.databinding.ActivityPlaylistVideosBinding
import com.example.youtubeapi.extensions.gone
import com.example.youtubeapi.extensions.visible
import com.example.youtubeapi.model.Items
import com.example.youtubeapi.ui.playList.PlayListViewModel
import com.example.youtubeapi.ui.playList.PlaylistAdaptor

class PlaylistVideosActivity :BaseActivity<ActivityPlaylistVideosBinding>(){

    private val viewModel by lazy {  ViewModelProvider(this)[PlayListitemsViewModel::class.java] }
    private var videos: ArrayList<Items>? = arrayListOf()
    private val playlistAdaptor by lazy { videos?.let { PlaylistAdaptor(it) } }


    override fun inflateViewBinding(): ActivityPlaylistVideosBinding {
       return ActivityPlaylistVideosBinding.inflate(layoutInflater)
    }

    override fun initViewModel() {
        val playlistId = intent.getStringExtra("id")
        binding.progressCircular.visible()
        if (playlistId != null)
            viewModel.getPlaylistItems(playlistId).observe(this){response ->
                if (response.isSuccessful && response.body() != null){
                 binding.progressCircular.gone()
                    videos = response.body()?.items
                 binding.rvVideo.adapter = playlistAdaptor
                    binding.tvPlaylistTitle.text = intent.getStringExtra("title")
                    binding.tvPlaylistDesc.text = intent.getStringExtra("desc")
             }
            }
    }

    override fun checkInternet() {

    }

    override fun initClickListener() {

    }

    override fun setUI() {
    }

}