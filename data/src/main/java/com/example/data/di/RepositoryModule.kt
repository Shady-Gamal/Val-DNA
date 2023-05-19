package com.example.data.di

import com.example.data.repositoriesContracts.agents.AgentsRepositoryImpl
import com.example.data.repositoriesContracts.maps.MapsOnlineDataSourceImpl
import com.example.data.repositoriesContracts.maps.MapsRepositoryImpl
import com.example.data.repositoriesContracts.weapons.WeaponsRepositoryImpl
import com.example.domain.repository.AgentsRepository
import com.example.domain.repository.MapsRepository
import com.example.domain.repository.WeaponsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAgentsRepository(agentsRepositoryImpl: AgentsRepositoryImpl) : AgentsRepository


    @Binds
    @Singleton
    abstract fun bindWeaponsRepository(weaponsRepositoryImpl : WeaponsRepositoryImpl) : WeaponsRepository

    @Binds
    @Singleton
    abstract fun bindMapsRepository(mapsRepositoryImpl: MapsRepositoryImpl) : MapsRepository
}