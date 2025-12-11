import com.example.build.logic.configureCoroutineAndroid
import com.example.build.logic.configureHiltAndroid
import com.example.build.logic.configureKotest
import com.example.build.logic.configureKotlinAndroid

plugins {
    id("com.android.library")
}

configureKotlinAndroid()
configureKotest()
configureCoroutineAndroid()
configureHiltAndroid()