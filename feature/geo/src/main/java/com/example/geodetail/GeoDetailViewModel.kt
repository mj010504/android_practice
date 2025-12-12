package com.example.geodetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.domain.repository.LocationRepository
import com.example.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GeoDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val locationRepository: LocationRepository,
) : ViewModel() {
    private val _state: MutableStateFlow<GeoDetailState> = MutableStateFlow(GeoDetailState())
    val state = _state.asStateFlow()

    init {
        val routeArgs: Screen.GeoDetail = savedStateHandle.toRoute()
        val id = routeArgs.id

        viewModelScope.launch {
            locationRepository.getLocationDetail(id).collect {
                _state.update { currentState ->
                    currentState.copy(location = it)
                }
            }
        }
    }
}