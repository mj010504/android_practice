import com.example.build.logic.configureHiltAndroid
import com.example.build.logic.findLibrary

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

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":core:domain"))
    
    implementation(findLibrary("hilt-navigation-compose").get())
    implementation(findLibrary("androidx.compose.navigation").get())

    implementation(findLibrary("androidx.lifecycle.viewModelCompose").get())
    implementation(findLibrary("androidx.lifecycle.runtimeCompose").get())

    implementation(findLibrary("androidx.navigation3.ui").get())
    implementation(findLibrary("androidx.navigation3.runtime").get())
    implementation(findLibrary("androidx.lifecycle.viewmodel.navigation3").get())

    androidTestImplementation(findLibrary("androidx.compose.ui.test").get())
    debugImplementation(findLibrary("androidx.compose.ui.test.manifest").get())
}
