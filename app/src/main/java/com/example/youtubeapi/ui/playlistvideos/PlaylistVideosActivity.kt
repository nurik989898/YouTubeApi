package com.example.youtubeapi.ui.playlistvideos
import android.os.Bundle
import com.example.youtubeapi.core.BaseActivity
import com.example.youtubeapi.databinding.ActivityPlaylistVideosBinding
import com.example.youtubeapi.extensions.gone
import com.example.youtubeapi.extensions.visible
import com.example.youtubeapi.model.Items
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaylistVideosActivity :BaseActivity<ActivityPlaylistVideosBinding>(){

    private val viewModel: PlayListitemsViewModel by viewModel()
    private var videos: ArrayList<Items>? = arrayListOf()
    private val playlistAdaptor by lazy { videos?.let { PlayListVideosAdaptor(it) } }

    override fun inflateViewBinding(): ActivityPlaylistVideosBinding {
       return ActivityPlaylistVideosBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.rvVideo.adapter = playlistAdaptor
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