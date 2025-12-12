package com.example.data.repository

import com.example.datastore.datasource.LocalLocationDataSource
import com.example.domain.model.Location
import com.example.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val localLocationDataSource: LocalLocationDataSource,
) : LocationRepository {
    override fun getLocations(): Flow<List<String>> = localLocationDataSource.locations

    override fun getLocationDetail(id: String): Flow<Location> =
        localLocationDataSource.getLocation(id)

    override suspend fun saveLocation(location: Location) {
        localLocationDataSource.saveLocation(location)
    }
}