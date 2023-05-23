package com.example.valorant.di

import com.example.domain.repository.*
import com.example.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Singleton
    @Provides
    fun provideAgentsUseCase(agentsRepository: AgentsRepository) : GetAgentsUseCase{
        return GetAgentsUseCase(agentsRepository)

    }


    @Singleton
    @Provides
    fun provideWeaponsUseCase(weaponsRepository: WeaponsRepository) : GetWeaponsUseCase{
        return GetWeaponsUseCase(weaponsRepository)
    }


    @Singleton
    @Provides
    fun provideMapsUseCase(mapsRepository: MapsRepository) : GetMapsUseCase{

        return GetMapsUseCase(mapsRepository)

    }

    @Singleton
    @Provides
    fun provideSelectedAgentUseCase(agentsRepository: AgentsRepository) : GetSelectedAgentUseCase{
        return GetSelectedAgentUseCase(agentsRepository)
    }

    @Provides
    @Singleton
    fun provideBundlesUseCase(bundlesRepository: BundlesRepository) : GetBundlesUseCase{

        return GetBundlesUseCase(bundlesRepository)
    }

    @Provides
    @Singleton
    fun provideBuddiesUseCase(buddiesRepository: BuddiesRepository) : GetBuddiesUseCase{

        return GetBuddiesUseCase(buddiesRepository)
    }
    @Singleton
    @Provides
    fun providePlayerCardsUseCase(playerCardsRepository: PlayerCardsRepository) : GetPlayerCardsUseCase{
        return GetPlayerCardsUseCase((playerCardsRepository))
    }

    @Singleton
    @Provides
    fun provideSpraysUseCase(spraysRepository: SpraysRepository) : GetSpraysUSeCase{

        return GetSpraysUSeCase(spraysRepository)
    }

    @Singleton
    @Provides
    fun provideSelectedWeaponUseCase(weaponsRepository: WeaponsRepository) : GetSelectedWeaponUseCase{

        return GetSelectedWeaponUseCase(weaponsRepository)
    }
}
