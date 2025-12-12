package com.example.datastore.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.domain.model.Location
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class LocalLocationDataSourceImpl @Inject constructor(
    @Named("location") private val dataStore: DataStore<Preferences>,
) : LocalLocationDataSource {

    private val json = Json { ignoreUnknownKeys = true }

    // 저장된 Location ID 목록만 Flow로 제공
    override val locations: Flow<List<String>> = dataStore.data.map { preferences ->
        getCurrentLocations(preferences).map { it.id }
    }

    // 특정 ID의 Location을 Flow로 제공
    override fun getLocation(id: String): Flow<Location> = dataStore.data.map { preferences ->
        getCurrentLocations(preferences).first { it.id == id }
    }

    // Location 저장 (기존 리스트에 추가하거나 업데이트)
    override suspend fun saveLocation(location: Location) {
        dataStore.edit { preferences ->
            val currentList = getCurrentLocations(preferences).toMutableList()

            // 같은 ID가 있으면 업데이트, 없으면 추가
            val existingIndex = currentList.indexOfFirst { it.id == location.id }
            if (existingIndex >= 0) {
                currentList[existingIndex] = location
            } else {
                currentList.add(location)
            }

            preferences[LOCATIONS_KEY] = json.encodeToString(currentList)
        }
    }

    // Location 삭제
    override suspend fun deleteLocation(locationId: String) {
        dataStore.edit { preferences ->
            val currentList = getCurrentLocations(preferences)
            val updatedList = currentList.filter { it.id != locationId }
            preferences[LOCATIONS_KEY] = json.encodeToString(updatedList)
        }
    }

    // 전체 삭제
    override suspend fun clearAllLocations() {
        dataStore.edit { preferences ->
            preferences[LOCATIONS_KEY] = "[]"
        }
    }

    // 현재 저장된 Location 리스트 파싱
    private fun getCurrentLocations(preferences: Preferences): List<Location> {
        val jsonString = preferences[LOCATIONS_KEY] ?: "[]"
        return runCatching {
            json.decodeFromString<List<Location>>(jsonString)
        }.getOrDefault(emptyList())
    }

    companion object {
        private val LOCATIONS_KEY = stringPreferencesKey("locations")
    }
}
