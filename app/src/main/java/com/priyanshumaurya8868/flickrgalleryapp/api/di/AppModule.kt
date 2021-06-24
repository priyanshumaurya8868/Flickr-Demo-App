package com.priyanshumaurya8868.flickrgalleryapp.api.di

import com.priyanshumaurya8868.flickrgalleryapp.Constants
import com.priyanshumaurya8868.flickrgalleryapp.api.GalleryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(): GalleryInterface {
        return Retrofit.Builder()
            .baseUrl(Constants.Base_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(GalleryInterface::class.java)
    }

}