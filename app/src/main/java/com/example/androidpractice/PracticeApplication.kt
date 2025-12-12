package com.example.androidpractice

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PracticeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}