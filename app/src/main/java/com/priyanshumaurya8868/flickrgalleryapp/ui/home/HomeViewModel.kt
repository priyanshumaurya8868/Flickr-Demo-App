package com.priyanshumaurya8868.flickrgalleryapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priyanshumaurya8868.flickrgalleryapp.api.GalleryRepo
import com.priyanshumaurya8868.flickrgalleryapp.api.models.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val repo: GalleryRepo) : ViewModel() {

    init {
       getPics()
    }


private val _photos = MutableLiveData<List<Photo>>()
    val photo : LiveData<List<Photo>> = _photos

    private fun getPics() = viewModelScope.launch(Dispatchers.IO) {
        _photos.postValue(repo.getPics().body()?.photos?.photo )
    }
}