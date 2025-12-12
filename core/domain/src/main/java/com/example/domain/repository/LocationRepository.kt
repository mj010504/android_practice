package com.example.domain.repository

import com.example.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    fun getLocations(): Flow<List<String>>
    fun getLocationDetail(id: String): Flow<Location>
    suspend fun saveLocation(location: Location)
}