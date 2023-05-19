package com.example.valorant.ui.maps_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.domain.entities.MapItemDTO

class MapsScreenViewModel(
     savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {
        savedStateHandle.get<List<MapItemDTO>>("param")
    }

}