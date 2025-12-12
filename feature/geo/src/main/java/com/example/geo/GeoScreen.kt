
package com.example.geo

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun GeoRoute(
    navigateToGeoDetail : () -> Unit,
    viewModel : GeoViewModel = hiltViewModel(),
) {
   GeoScreen()
}

@Composable
private fun GeoScreen() {}

