package com.priyanshumaurya8868.flickrgalleryapp.api

import javax.inject.Inject

class GalleryRepo@Inject constructor(val galleryInterface : GalleryInterface){

    suspend fun getPics() = galleryInterface.getPics()

}