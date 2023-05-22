package com.example.data.di

import com.example.data.repositoriesContracts.PlayerCards.PlayerCardsRepositoryImpl
import com.example.data.repositoriesContracts.Sprays.SpraysRepositoryImpl
import com.example.data.repositoriesContracts.agents.AgentsRepositoryImpl
import com.example.data.repositoriesContracts.buddies.BuddiesRepositoryImpl
import com.example.data.repositoriesContracts.bundles.BundlesRepositoryImpl
import com.example.data.repositoriesContracts.maps.MapsOnlineDataSourceImpl
import com.example.data.repositoriesContracts.maps.MapsRepositoryImpl
import com.example.data.repositoriesContracts.weapons.WeaponsRepositoryImpl
import com.example.domain.repository.*
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


    @Singleton
    @Binds
    abstract fun bindBundlesRepository(bundlesRepositoryImpl: BundlesRepositoryImpl) : BundlesRepository

    @Singleton
    @Binds
    abstract fun bindBuddiesRepository(buddiesRepositoryImpl: BuddiesRepositoryImpl) : BuddiesRepository
    @Singleton
    @Binds
    abstract fun bindPlayerCardsRepository(playerCardsRepositoryImpl: PlayerCardsRepositoryImpl) : PlayerCardsRepository


@Singleton
@Binds
abstract fun bindSprayRepository(spraysRepositoryImpl: SpraysRepositoryImpl): SpraysRepository
}