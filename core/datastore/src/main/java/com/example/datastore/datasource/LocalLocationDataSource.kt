package com.example.datastore.datasource

import com.example.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface LocalLocationDataSource {
    val locations: Flow<List<String>>
    fun getLocation(id: String): Flow<Location>
    suspend fun saveLocation(location: Location)
    suspend fun deleteLocation(locationId: String)
    suspend fun clearAllLocations()
}