import com.example.build.logic.configureHiltAndroid

plugins {
    id("practice.android.library")
    id("practice.android.compose")
}

android {
    packaging {
        resources {
            excludes.add("META-INF/**")
        }
    }

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

configureHiltAndroid()

dependencies {}
