package com.example.geodetail

import com.example.domain.model.Location

data class GeoDetailState(
    val location : Location = Location("", 0.0, 0.0),
)