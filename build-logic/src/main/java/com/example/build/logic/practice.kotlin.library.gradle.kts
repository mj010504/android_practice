import com.example.build.logic.configureKotest
import com.example.build.logic.configureKotlin
import org.gradle.kotlin.dsl.kotlin

plugins {
    kotlin("jvm")
}

configureKotlin()
configureKotest()
