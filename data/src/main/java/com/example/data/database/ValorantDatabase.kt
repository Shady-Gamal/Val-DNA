package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.model.AgentsDataItem

@Database(entities = [AgentsDataItem::class], version = 1)
@TypeConverters(Converters::class)
abstract class ValorantDatabase : RoomDatabase() {

 abstract fun getAgentsDao() : AgentsDao

}