plugins {
    id("practice.android.library")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.navigation"
}

dependencies {
    implementation(projects.core.domain)

    implementation(libs.androidx.navigation3.ui)
    implementation(libs.kotlinx.serialization.json)
}