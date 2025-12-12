plugins {
    id("practice.kotlin.library")
    id("practice.kotlin.hilt")
    alias(libs.plugins.kotlin.serialization)
}

dependencies {
    implementation(libs.coroutines.core)
    implementation(libs.kotlinx.serialization.json)
}


