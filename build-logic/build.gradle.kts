plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.compiler.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidHilt") {
            id = "practice.android.hilt"
            implementationClass = "com.example.build.logic.HiltAndroidPlugin"
        }
        register("kotlinHilt") {
            id = "practice.kotlin.hilt"
            implementationClass = "com.example.build.logic.HiltKotlinPlugin"
        }
    }
}
