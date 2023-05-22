package com.example.data.di

import com.example.data.repositoriesContracts.PlayerCards.PlayerCardsOfflineDataSourceImpl
import com.example.data.repositoriesContracts.PlayerCards.PlayerCardsOnlineDataSourceImpl
import com.example.data.repositoriesContracts.Sprays.SpraysOnlineDataSourceImpl
import com.example.data.repositoriesContracts.agents.AgentsOfflineDataSourceImpl
import com.example.data.repositoriesContracts.agents.AgentsOnlineDataSourceImpl
import com.example.data.repositoriesContracts.buddies.BuddiesOfflineDataSourceImpl
import com.example.data.repositoriesContracts.buddies.BuddiesOnlineDataSourceImpl
import com.example.data.repositoriesContracts.bundles.BundlesOfflineDataSourceImpl
import com.example.data.repositoriesContracts.bundles.BundlesOnlineDataSourceImpl
import com.example.data.repositoriesContracts.maps.MapsOnlineDataSourceImpl
import com.example.data.repositoriesContracts.weapons.WeaponOnlineDataSourceImpl
import com.example.data.repositoriesContracts.weapons.WeaponsOfflineDataSourceImpl
import com.example.domain.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindAgentsDataSource(agentsOnlineDataSourceImpl : AgentsOnlineDataSourceImpl) : AgentsOnlineDataSource

    @Binds
    @Singleton
    abstract fun bindAgentsOfflineDataSource(agentsOfflineDataSourceImpl: AgentsOfflineDataSourceImpl) : AgentsOfflineDataSource

    @Binds
    @Singleton
    abstract fun bindWeaponsDataSource(weaponOnlineDataSourceImpl: WeaponOnlineDataSourceImpl) : WeaponsOnlineDataSource

    @Singleton
    @Binds
    abstract fun bindWeaponsOfflineDataSource(weaponsOfflineDataSourceImpl: WeaponsOfflineDataSourceImpl) : WeaponsOfflineDataSource

    @Binds
    @Singleton
    abstract fun bindMapsDataSource(mapsOnlineDataSourceImpl: MapsOnlineDataSourceImpl) : MapsOnlineDataSource

    @Binds
    @Singleton
    abstract fun bindBundlesOnlineDataSource(bundlesOnlineDataSourceImpl: BundlesOnlineDataSourceImpl) : BundlesOnlineDataSource

    @Binds
    @Singleton
    abstract fun bindBundlesOfflineDataSource(bundlesOfflineDataSourceImpl: BundlesOfflineDataSourceImpl) : BundlesOfflineDataSource

    @Binds
    @Singleton
    abstract fun bindBuddiesOnlineDataSource(buddiesOnlineDataSourceImpl: BuddiesOnlineDataSourceImpl) : BuddiesOnlineDataSource

    @Binds
    @Singleton
    abstract fun bindBuddiesOfflineDataSource(buddiesOfflineDataSourceImpl: BuddiesOfflineDataSourceImpl) : BuddiesOfflineDataSource
    @Binds
    @Singleton
    abstract fun bindPlayerCardsOnlineDatsSource(playerCardsOnlineDataSourceImpl: PlayerCardsOnlineDataSourceImpl) : PlayerCardsOnlineDataSource

    @Binds
    @Singleton
    abstract fun bindPlayerCardsOfflineDataSource(playerCardsOfflineDataSourceImpl: PlayerCardsOfflineDataSourceImpl) : PlayerCardsOfflineDataSource

    @Binds
    @Singleton
    abstract fun bindSpraysOnlineDataSource(spraysOnlineDataSourceImpl : SpraysOnlineDataSourceImpl) : SpraysOnlineDataSource
}
