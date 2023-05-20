package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.database.DataBaseDAO.AgentsDao
import com.example.data.database.DataBaseDAO.BundlesDao
import com.example.data.database.DataBaseDAO.WeaponsDao
import com.example.data.model.AgentsDataItem
import com.example.data.model.BundlesDataItem
import com.example.data.model.WeaponsDataItem

@Database(entities = [AgentsDataItem::class, WeaponsDataItem::class, BundlesDataItem::class],
 version = 3)
@TypeConverters(Converters::class)
abstract class ValorantDatabase : RoomDatabase() {

 abstract fun getAgentsDao() : AgentsDao

 abstract fun getWeaponsDAO() : WeaponsDao

 abstract fun getBundlesDAO() : BundlesDao

}