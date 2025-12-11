import com.example.build.logic.configureHiltAndroid
import com.example.build.logic.configureKotestAndroid
import com.example.build.logic.configureKotlinAndroid

plugins {
    id("com.android.application")
}

configureKotlinAndroid()
configureHiltAndroid()
configureKotestAndroid()
