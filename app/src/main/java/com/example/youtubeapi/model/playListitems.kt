package com.example.youtubeapi.model

data class playListitems(
    val etag: String,
    val items: List<Items>,
    val kind: String,
    val pageInfo: PageInfo
)