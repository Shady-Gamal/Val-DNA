package com.example.data.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.database.Converters
import com.example.data.database.ValorantDatabase
import com.example.data.util.GsonParser
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "Valorant_Database"

    @Provides
    @Singleton
    fun provideRoomDataBase(@ApplicationContext context : Context) : ValorantDatabase{

        return Room.databaseBuilder(context, ValorantDatabase::class.java , DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .addTypeConverter(Converters(GsonParser(Gson())))
            .build()


    }
}