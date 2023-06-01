package com.example.valorant.ui.weaponSkins_screen

import com.example.valorant.ui.weaponDetails_screen.WeaponDetailsState

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Resource
import com.example.domain.usecases.GetSelectedWeaponUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeaponSkinsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val getSelectedWeaponUseCase: GetSelectedWeaponUseCase
) : ViewModel() {

    var weaponSkinsState by mutableStateOf(WeaponSkinsState())

    init {
        savedStateHandle.get<String>("weaponId")?.let {
            getSelectedWeaponSkins(it)
        }
    }

    fun getSelectedWeaponSkins(uuid : String){

        viewModelScope.launch {
            getSelectedWeaponUseCase.invoke(uuid).collect{

                when (it){
                    is Resource.Success -> {
                        weaponSkinsState = weaponSkinsState.copy(
                            WeaponSkins = it.data
                        )
                        Log.e("weps", it.data?.skins?.size.toString() )
                    }
                    is Resource.Error -> {
                        weaponSkinsState = weaponSkinsState.copy(
                            error = it.message)
                        Log.e("weps", it.message.toString() )
                    }


                    is Resource.Loading -> weaponSkinsState = weaponSkinsState.copy(
                        isLoading = true
                    )

                }
            }
        }
    }


}