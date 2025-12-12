package com.example.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.geo.GeoRoute

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier,
) {
    val backstack = remember {
        mutableStateListOf<Any>(GeoRoute)
    }

    NavDisplay(
        backStack = backstack,
        onBack = { backstack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
        ),
        entryProvider = { key ->
            when (key) {
                is GeoRoute -> {
                    NavEntry(key) {
                        GeoRoute(
                            navigateToGeoDetail = {}
                        )
                    }
                }

                else -> error("Unknown NavKey")
            }
        }
    )
}
        