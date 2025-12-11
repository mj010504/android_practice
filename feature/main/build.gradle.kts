plugins {
    id("practice.android.feature")
}

android {
    namespace = "com.example.main"

}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.lifecycle.viewModelCompose)

    implementation(projects.core.designsystem)
    implementation(projects.core.domain)
    implementation(projects.feature.geo)
}
