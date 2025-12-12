package com.example.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.datastore.datasource.LocalLocationDataSource
import com.example.datastore.datasource.LocalLocationDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreProvidesModule {
    private const val LOCATION_DATASTORE_NAME = "LOCATION_PREFERENCES"
    private val Context.locationDataStore by preferencesDataStore(name = LOCATION_DATASTORE_NAME)

    @Provides
    @Singleton
    @Named("location")
    fun provideLocationDataStore(
        @ApplicationContext context: Context,
    ): DataStore<Preferences> = context.locationDataStore
}

@Module
@InstallIn(SingletonComponent::class)
abstract class DatastoreBindsModule {
    @Binds
    @Singleton
    abstract fun bindsLocalLocationDataSource(
        localLocationDataSourceImpl: LocalLocationDataSourceImpl,
    ): LocalLocationDataSource
}
