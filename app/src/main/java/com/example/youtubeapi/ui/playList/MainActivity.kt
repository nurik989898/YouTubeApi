package com.example.youtubeapi.ui.playList
import android.content.Intent
import com.example.youtubeapi.core.BaseActivity
import com.example.youtubeapi.databinding.ActivityMainBinding
import com.example.youtubeapi.model.Items
import com.example.youtubeapi.ui.playlistvideos.PlaylistVideosActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(),ItemClickListener{
    private val viewModel:PlayListViewModel by viewModel()
    private var playlist: ArrayList<Items>? = arrayListOf()
    private val playlistAdaptor by lazy { playlist?.let { PlaylistAdaptor(it) } }
    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
    override fun initViewModel() {
        viewModel.getPlaylist().observe(this){response ->
           if (response.body() != null) {
               playlist = response.body()?.items
           }
            playlistAdaptor?.setListener(this)
            binding.rvPlaylists.adapter = playlistAdaptor
        }

    }


    override fun checkInternet() {
    }

    override fun initClickListener() {

    }

    override fun setUI() {
    }

    override fun onItemClick(id: String,title:String,desc: String) {
 //val intent = Intent(this,PlaylistVideosActivity::class.java)
  //      intent.putExtra("id",id)
   //     startActivity(intent)
        Intent(this,PlaylistVideosActivity::class.java).apply {
            putExtra("id", id)
            putExtra("desc",desc)
            putExtra("title",title)
            startActivity(this)
        }
    }
}