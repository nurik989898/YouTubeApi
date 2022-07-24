package com.example.youtubeapi.di

import com.example.youtubeapi.ui.playlistvideos.PlayListitemsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { PlayListitemsViewModel(get()) }
    viewModel{PlayListitemsViewModel(get())}
}