package com.example.valorant.ui.weapons_Screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Resource
import com.example.domain.entities.WeaponItemDTO
import com.example.domain.usecases.GetWeaponsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeaponsViewModel @Inject constructor(
    val getWeaponsUseCase: GetWeaponsUseCase
) : ViewModel() {

     var weaponState by mutableStateOf(WeaponState())
    private set


    init {
        getWeapons()


    }

    fun getWeapons(){
        viewModelScope.launch{
            weaponState = weaponState.copy(
                isLoading = true
            )
            getWeaponsUseCase.invoke().collect{
                when (it){

                    is Resource.Success -> weaponState = weaponState.copy(
                        weaponsInfo = it.data
                        , isLoading = false
                    )
                    is Resource.Loading -> weaponState = weaponState.copy(
                        isLoading = true
                    )
                    is Resource.Error -> weaponState = weaponState.copy(
                        error = it.message

                    )
                }

            }
        }


    }

}