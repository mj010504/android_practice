plugins {
    id("practice.android.application")
    alias(libs.plugins.android.application)
}
android {
    namespace = "com.example.androidpractice"

    compileSdk {
        version = release(36)
    }

    defaultConfig {
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.core.domain)
}