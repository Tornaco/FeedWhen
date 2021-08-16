import tornaco.project.android.feedwhen.*

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
        compose = true
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

    implementation(Core.androidXCore)
    implementation(Core.appCompat)
    implementation(Core.material)
    implementation(Compose.runtimeSaveAble)
    implementation(Compose.ui)
    implementation(Compose.runtime)
    implementation(Compose.material)
    implementation(Compose.activityCompose)
    implementation(Compose.viewmodel)
    implementation(Compose.navigationCompose)
    implementation(Compose.hiltNavigation)
    implementation(Compose.tooling)
    implementation(Compose.toolingPreview)
    implementation(Libs.AndroidX.lifeCycleRuntime)

    implementation(Libs.Others.timber)

    implementation(project(":domain"))

    implementation(Libs.Hilt.library)
    add("kapt", Libs.Hilt.googleAndroidCompiler)
    add("kapt", Libs.Hilt.googleCompiler)

    testImplementation(Tests.junit)
    testImplementation(Tests.junitKotlin)
    testImplementation(Tests.mockk)
    testImplementation(Tests.mockito)
    testImplementation(Tests.androidXCoreTest)
    testImplementation(Tests.ktxCoroutinesTest)
    testImplementation(Libs.Room.testing)
}