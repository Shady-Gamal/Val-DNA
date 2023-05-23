package com.example.valorant.ui.weaponDetails_screen

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
class WeaponDetailsViewModel @Inject constructor(
savedStateHandle: SavedStateHandle,
val getSelectedWeaponUseCase: GetSelectedWeaponUseCase
) : ViewModel() {

    var selectedWeaponState by mutableStateOf(SelectedWeaponState())

    init {
        savedStateHandle.get<String>("weaponId")?.let {
            getSelectedWeapon(it)
        }
    }

    fun getSelectedWeapon(uuid : String){

        viewModelScope.launch {
            getSelectedWeaponUseCase.invoke(uuid).collect{

                when (it){
                    is Resource.Success -> {
                        selectedWeaponState = selectedWeaponState.copy(
                            selectedWeaponDetails = it.data
                        )
                        Log.e("weps", it.data?.skins?.size.toString() )
                    }
                    is Resource.Error -> {
                        selectedWeaponState = selectedWeaponState.copy(
                            error = it.message)
                        Log.e("weps", it.message.toString() )
                    }


                    is Resource.Loading -> selectedWeaponState = selectedWeaponState.copy(
                        isLoading = true
                    )

                }
            }
        }
    }


}