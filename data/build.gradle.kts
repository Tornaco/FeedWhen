import tornaco.project.android.feedwhen.Compose
import tornaco.project.android.feedwhen.Configs
import tornaco.project.android.feedwhen.Libs
import tornaco.project.android.feedwhen.Tests

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    defaultConfig {
        vectorDrawables.useSupportLibrary = true
        minSdk = Configs.minSdkVersion
        compileSdk = Configs.compileSdkVersion
        targetSdk = Configs.targetSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = false
        buildConfig = false
        aidl = false
        renderScript = false
        resValues = false
        shaders = false
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeVersion
    }
}

dependencies {
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Coroutines.android)

    implementation(Libs.Others.timber)
    implementation(Libs.Others.retrofit)
    implementation(Libs.Others.retrofit_converter_gson)
    implementation(Libs.Others.mockwebserver)


    implementation(Libs.Room.runtime)
    implementation(Libs.Room.ktx)
    add("kapt", Libs.Room.annotationProcessor)

    implementation(Libs.Hilt.library)
    add("kapt", Libs.Hilt.googleAndroidCompiler)
    add("kapt", Libs.Hilt.googleCompiler)

    implementation(project(":domain"))

    testImplementation(Tests.junit)
    testImplementation(Tests.junitKotlin)
    testImplementation(Tests.mockk)
    testImplementation(Tests.mockito)
    testImplementation(Tests.androidXCoreTest)
    testImplementation(Libs.Room.testing)
}