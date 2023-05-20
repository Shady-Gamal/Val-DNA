package com.example.valorant.di

import com.example.domain.repository.AgentsRepository
import com.example.domain.repository.BundlesRepository
import com.example.domain.repository.MapsRepository
import com.example.domain.repository.WeaponsRepository
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
}