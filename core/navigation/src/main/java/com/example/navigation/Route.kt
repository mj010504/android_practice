package com.example.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


sealed interface Screen : NavKey {
    @Serializable
    data object Geo : Screen

    @Serializable
    data class GeoDetail(val id : String) : Screen
}


