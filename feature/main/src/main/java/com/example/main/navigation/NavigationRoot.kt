package com.example.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.geo.GeoRoute
import com.example.navigation.Screen

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier,
) {
    val backstack = rememberNavBackStack(
        Screen.Geo
    )

    NavDisplay(
        backStack = backstack,
        onBack = { backstack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
        ),
        entryProvider = { key ->
            when (key) {
                is Screen.Geo -> {
                    NavEntry(key) {
                        GeoRoute(
                            navigateToGeoDetail = { id ->
                                backstack.add(Screen.GeoDetail(id))
                            }
                        )
                    }
                }

                else -> error("Unknown NavKey")
            }
        }
    )
}
        