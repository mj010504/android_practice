plugins {
    id("practice.android.library")
    id("practice.android.compose")
}

android {
    namespace = "com.example.designsystem"
}
dependencies {
    implementation(libs.androidx.compose.runtime)
}



