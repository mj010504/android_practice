package com.example.build.logic

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies


internal fun Project.configureComposeAndroid() {
    with(plugins) {
        apply("org.jetbrains.kotlin.plugin.compose")
    }

    androidExtension.apply {
        buildFeatures.apply {
            compose = true
        }

        dependencies {
            val bom = findLibrary("androidx-compose-bom")
            add("implementation", platform(bom))
            add("androidTestImplementation", platform(bom))

            add("implementation", findLibrary("androidx.compose.material3"))
            add("implementation", findLibrary("androidx.compose.ui"))
            add("implementation", findLibrary("androidx.compose.ui.tooling.preview"))
            add("implementation", findLibrary("androidx.compose.foundation").get())
            add("debugImplementation", findLibrary("androidx.compose.ui.tooling"))
        }
    }
}
