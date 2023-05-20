package com.example.valorant.ui.home_screen


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Resource
import com.example.domain.usecases.GetAgentsUseCase
import com.example.domain.usecases.GetMapsUseCase
import com.example.domain.usecases.GetWeaponsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAgentsUseCase: GetAgentsUseCase,
    private val getWeaponsUseCase: GetWeaponsUseCase,
    private val getMapsUseCase: GetMapsUseCase,

    ) : ViewModel() {

    var Homestate by mutableStateOf(HomeState())
        private set
    init {
        getAgents()
        getWeapons()
        getMaps()
    }
    fun getAgents(){
        viewModelScope.launch {
            getAgentsUseCase.invoke().collect{
                when (it){

                    is Resource.Success -> {
                        Homestate = Homestate.copy(
                            agentsInfo = it.data
                        )
                        Log.e("tag", Homestate.agentsInfo?.size.toString() )
                    }
                    is Resource.Error -> {
                        Homestate = Homestate.copy(
                            error = it.message
                        )
                        Log.e("tag", it.message.toString())
                    }
                    is Resource.Loading -> Homestate = Homestate.copy(
                        isLoading = true
                    )
                }
            }
        }
    }
    fun getWeapons(){

        viewModelScope.launch {
            getWeaponsUseCase.invoke().collect{
                when (it){

                    is Resource.Success -> Homestate = Homestate.copy(
                        weaponsInfo = it.data
                    )
                    is Resource.Loading -> Homestate = Homestate.copy(
                        isLoading = true
                    )
                    is Resource.Error -> Homestate = Homestate.copy(

                        error = it.message
                    )
                }
            }


        }
    }
    fun getMaps(){
viewModelScope.launch {
    getMapsUseCase.invoke().collect{

        when (it){

            is Resource.Success -> Homestate = Homestate.copy(
                mapsInfo = it.data
            )
            is Resource.Error -> Homestate = Homestate.copy(

                error = it.message
            )
            is Resource.Loading -> Homestate = Homestate.copy(

                isLoading = true
            )
        }
    }
}


    }

}