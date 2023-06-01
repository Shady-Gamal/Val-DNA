package com.example.valorant.di

import android.content.Context
import androidx.room.Room
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
object TestRoomModule {

    private const val DATABASE_NAME = "Valorant_Database"

    @Provides
    @Singleton
    fun provideRoomDataBase(@ApplicationContext context : Context) : ValorantDatabase{

        return Room.inMemoryDatabaseBuilder(context, ValorantDatabase::class.java)
            .addTypeConverter(Converters(GsonParser(Gson())))
            .fallbackToDestructiveMigration()
            .build()


    }
}
