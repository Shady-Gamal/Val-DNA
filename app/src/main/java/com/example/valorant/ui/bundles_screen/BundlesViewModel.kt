package com.example.valorant.ui.bundles_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    var itemCount by mutableStateOf(5)
    var pageNumb by mutableStateOf(0)
    val defaultItemCount = 5


    init {
        getBundles()
    }

    fun getBundles(){
        viewModelScope.launch {
            getBundlesUseCase.invoke().collect{

                when (it){
                    is Resource.Success ->
                        bundlesState = bundlesState.copy(
                            bundlesInfo = it.data
                        )

                    is Resource.Loading -> bundlesState = bundlesState.copy(
                        isLoading = true
                    )
                    is Resource.Error ->
                        bundlesState = bundlesState.copy(
                            error = it.message
                        )

                }
            }
        }
    }
    fun calculateSizeOfPage() {
        Log.e("holahaivto", itemCount.toString())
        Log.e("TAG", pageNumb.toString())
        bundlesState.bundlesInfo?.let {
            val lastPage = (bundlesState.bundlesInfo?.size?.div(itemCount))
            if (pageNumb == lastPage!!) {
                itemCount = bundlesState.bundlesInfo?.size?.rem(itemCount)!!
            }
            else{
                itemCount= defaultItemCount
            }

        }

    }
    fun calculateLastPageIndex() : Int{

        return bundlesState.bundlesInfo?.size?.div(defaultItemCount)!!
    }
    fun getItemByIndex(index : Int) : Int{
        return (index + (pageNumb * defaultItemCount))
    }

}