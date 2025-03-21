package com.example.myapplication

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PlaceScreenViewModel: ViewModel() {
    var uiState = mutableStateOf<PlaceScreenState>(PlaceScreenState.Loading)
        private set

    private val placeRepository = PlaceRepository()

    // Метод для получения данных
    fun fetchPlace() {
        uiState.value = PlaceScreenState.Loading
        viewModelScope.launch {
            val places = placeRepository.getPlaces()
            withContext(Dispatchers.Default) {
                uiState.value = PlaceScreenState.Success(places)
            }
        }


    }
}

sealed class PlaceScreenState {
    object Loading : PlaceScreenState()  // Состояние загрузки
    data class Success(val currentPlaces: List<Place>) : PlaceScreenState()  // Данные загружены
}