package com.example.geo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Location
import com.example.domain.repository.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GeoViewModel @Inject constructor(
    private val locationRepository: LocationRepository,
) : ViewModel() {
    private val _state: MutableStateFlow<GeoState> = MutableStateFlow(GeoState())
    val state = _state.asStateFlow()

    init {
        saveLocations()

        viewModelScope.launch {
            locationRepository.getLocations().collect { locations ->
                _state.update { currentState ->
                    currentState.copy(locations = locations)
                }
            }
        }
    }

    private fun saveLocations() = viewModelScope.launch {
        val locations = listOf(
            Location(
                id = "마루180",
                latitude = 37.49542,
                longitude = 127.03884,
            ),
            Location(
                id = "서울역",
                latitude = 37.55403,
                longitude = 126.97073,
            ),
            Location(
                id = "부산역",
                latitude = 35.16438,
                longitude = 129.06004,
            )
        )

        locations.forEach {
            locationRepository.saveLocation(it)
        }
    }
}