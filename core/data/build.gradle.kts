plugins {
    id("practice.android.library")
    id("practice.android.hilt")
}

android {
    namespace = "com.eample.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.datastore)

    implementation(libs.kotlinx.datetime)
}
