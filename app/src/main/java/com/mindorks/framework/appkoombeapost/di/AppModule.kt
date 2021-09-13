package com.mindorks.framework.appkoombeapost.di

import android.content.Context
import com.mindorks.framework.appkoombeapost.data.local.AppDatabase
import com.mindorks.framework.appkoombeapost.data.local.PostDao
import com.mindorks.framework.appkoombeapost.data.remote.PosterRemoteDataSource
import com.mindorks.framework.appkoombeapost.data.remote.PostService
import com.mindorks.framework.appkoombeapost.data.repository.PostRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun providePostService(retrofit: Retrofit): PostService = retrofit.create(PostService::class.java)

    @Singleton
    @Provides
    fun providePosterRemoteDataSource(posterService: PostService) = PosterRemoteDataSource(posterService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun providePosterDao(db: AppDatabase) = db.posterDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: PosterRemoteDataSource,
                          localDataSource: PostDao) =
        PostRepository(remoteDataSource, localDataSource)
}