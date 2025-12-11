plugins {
    id("practice.android.library")
    id("practice.android.hilt")
}

android {
    namespace = "com.example.datastore"

}

dependencies {
    implementation(projects.core.domain)
    implementation(libs.androidx.datastore)
}
