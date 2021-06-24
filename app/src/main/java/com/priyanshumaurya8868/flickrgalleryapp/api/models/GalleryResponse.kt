package com.priyanshumaurya8868.flickrgalleryapp.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GalleryResponse(
    @Json(name = "photos")
    val photos: Photos,
    @Json(name = "stat")
    val stat: String
)