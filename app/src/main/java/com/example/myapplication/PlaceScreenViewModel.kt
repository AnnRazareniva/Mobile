package com.example.myapplication

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
//
class AppUIState(
    val ScreenState: PlaceScreenState = PlaceScreenState.Loading

)

class PlaceScreenViewModel: ViewModel() {
    var uiState = mutableStateOf<AppUIState>(AppUIState())
        private set

    private val placeRepository = PlaceRepository()

    // Метод для получения данных
    fun fetchPlace() {
        uiState.value = AppUIState()
        viewModelScope.launch {
            val places = placeRepository.getPlaces()
            withContext(Dispatchers.Default) {
                uiState.value = AppUIState(PlaceScreenState.Success(places))
            }
        }
    }

    init {
        uiState.value = AppUIState()
    }
}


sealed class PlaceScreenState {
    object Loading : PlaceScreenState()  // Состояние загрузки
    data class Success(val currentPlaces: List<Place>) : PlaceScreenState()  // Данные загружены
}