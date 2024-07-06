package com.example.valorant.ui.home_screen


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Resource
import com.example.domain.usecases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAgentsUseCase: GetAgentsUseCase,
    private val getWeaponsUseCase: GetWeaponsUseCase,
    private val getMapsUseCase: GetMapsUseCase,
    private val getPlayerCardsUseCase: GetPlayerCardsUseCase,
    private val getBundlesUseCase: GetBundlesUseCase

    ) : ViewModel() {

    var homeState by mutableStateOf(HomeState())
        private set
    init {
        getAgents()
        getWeapons()
        getMaps()
        getPlayerCards()
        getBundles()
    }
    private fun getAgents(){
        viewModelScope.launch {
            getAgentsUseCase.invoke().collect{
                when (it){

                    is Resource.Success -> homeState = homeState.copy(
                            agentsInfo = it.data
                        )

                    is Resource.Error ->
                        homeState = homeState.copy(
                            error = it.message
                        )

                    is Resource.Loading -> homeState = homeState.copy(
                        isLoading = true
                    )
                }
            }
        }
    }
    private fun getWeapons(){

        viewModelScope.launch {
            getWeaponsUseCase.invoke().collect{
                when (it){

                    is Resource.Success -> homeState = homeState.copy(
                        weaponsInfo = it.data
                    )
                    is Resource.Loading -> homeState = homeState.copy(
                        isLoading = true
                    )
                    is Resource.Error -> homeState = homeState.copy(

                        error = it.message
                    )
                }
            }


        }
    }
    private fun getMaps(){
viewModelScope.launch {
    getMapsUseCase.invoke().collect{

        when (it){

            is Resource.Success -> homeState = homeState.copy(
                mapsInfo = it.data
            )
            is Resource.Error -> homeState = homeState.copy(

                error = it.message
            )
            is Resource.Loading -> {
                homeState = homeState.copy(

                    isLoading = true

                )

            }
        }
    }
}


    }
    private fun getPlayerCards(){

        viewModelScope.launch {
            getPlayerCardsUseCase.invoke().collect{
                when (it){
                    is Resource.Success -> homeState = homeState.copy(
                        playerCardsInfo = it.data
                    )
                    is Resource.Error -> homeState = homeState.copy(
                        error = it.message
                    )
                    is Resource.Loading -> homeState = homeState.copy(
                        isLoading = true
                    )

                }
            }
        }
    }

    private fun getBundles(){
        viewModelScope.launch {

            homeState = homeState.copy(
                isLoading = true
            )
            getBundlesUseCase.invoke().collect{

                when (it){
                    is Resource.Success ->
                        homeState = homeState.copy(
                            bundlesInfo = it.data
                        )

                    is Resource.Loading -> homeState = homeState.copy(
                        isLoading = true
                    )
                    is Resource.Error ->
                        homeState = homeState.copy(
                            error = it.message
                        )


                }
            }
        }
    }

}