package com.example.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val id: String,
    val latitude: Double,
    val longitude: Double,
    val logs: List<String> = emptyList(),
)
