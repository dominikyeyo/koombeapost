package com.mindorks.framework.appkoombeapost.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mindorks.framework.appkoombeapost.data.entities.Data
import com.mindorks.framework.appkoombeapost.data.entities.convertersdatabase.PostsTypesToStringConverter

@Database(entities = [Data::class], version = 1, exportSchema = false)
@TypeConverters(PostsTypesToStringConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun posterDao(): PostDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "posts")
                .fallbackToDestructiveMigration()
                .build()
    }

}