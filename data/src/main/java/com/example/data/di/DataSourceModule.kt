package com.example.data.di

import com.example.data.repositoriesContracts.agents.AgentsOfflineDataSourceImpl
import com.example.data.repositoriesContracts.agents.AgentsOnlineDataSourceImpl
import com.example.data.repositoriesContracts.maps.MapsOnlineDataSourceImpl
import com.example.data.repositoriesContracts.weapons.WeaponOnlineDataSourceImpl
import com.example.domain.repository.AgentsOfflineDataSource
import com.example.domain.repository.AgentsOnlineDataSource
import com.example.domain.repository.MapsOnlineDataSource
import com.example.domain.repository.WeaponsOnlineDataSource
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

    @Binds
    @Singleton
    abstract fun bindMapsDataSource(mapsOnlineDataSourceImpl: MapsOnlineDataSourceImpl) : MapsOnlineDataSource
 }