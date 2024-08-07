package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.database.DataBaseDAO.*
import com.example.data.model.*

@Database(entities = [AgentsDataItem::class, WeaponsDataItem::class, BundlesDataItem::class,
 BuddiesDataItem::class, PlayerCardsDataItem::class, MapsDataItem::class, SpraysDataItem::class],
 version = 8)
@TypeConverters(Converters::class)
abstract class ValorantDatabase : RoomDatabase() {

 abstract fun getAgentsDao() : AgentsDao

 abstract fun getWeaponsDao() : WeaponsDao

 abstract fun getBundlesDao() : BundlesDao
 abstract fun getBuddiesDao() : BuddiesDao

 abstract fun getPlayerCardsDao() : PlayerCardsDao

 abstract fun getMapsDao() : MapsDao

 abstract fun getSpraysDao() : SpraysDao
}