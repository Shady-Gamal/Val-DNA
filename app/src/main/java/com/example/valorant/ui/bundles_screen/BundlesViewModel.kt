package com.example.valorant.ui.bundles_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Resource
import com.example.domain.usecases.GetBundlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BundlesViewModel @Inject constructor(
   val getBundlesUseCase: GetBundlesUseCase
): ViewModel() {
    var bundlesState by mutableStateOf(BundlesState())


    init {
        getstate()
    }
    fun getstate(){
        viewModelScope.launch {
            getBundlesUseCase.invoke().collect{

                when (it){
                    is Resource.Success -> {
                        bundlesState = bundlesState.copy(
                            bundlesInfo = it.data
                        )
                        Log.e("tag", it.data?.size.toString() )
                    }
                    is Resource.Loading -> bundlesState = bundlesState.copy(
                        isLoading = true
                    )
                    is Resource.Error -> {
                        bundlesState = bundlesState.copy(
                            error = it.message
                        )
                        Log.e("tag", it.message ?: "null" )
                    }

                }
            }
        }
    }

}