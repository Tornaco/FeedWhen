import tornaco.project.android.rennixing.*

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("rennixingPlugin")
}

android {
    defaultConfig {
        applicationId = Configs.appId
        versionName = Configs.versionName
        versionCode = Configs.versionCode
        minSdk = Configs.minSdkVersion
        compileSdk = Configs.compileSdkVersion
        targetSdk = Configs.targetSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
            Configs["keyStore"]?.also {
                storeFile = rootProject.file(it)
                storePassword = Configs["storePassword"]
                keyAlias = Configs["keyAlias"]
                keyPassword = Configs["keyPassword"]
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
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
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeVersion
    }
}

dependencies {
    implementation(Core.androidXCore)
    implementation(Core.appCompat)
    implementation(Core.material)
    implementation(Compose.runtimeSaveAble)
    implementation(Compose.ui)
    implementation(Compose.runtime)
    implementation(Compose.material)
    implementation(Compose.activityCompose)
    implementation(Compose.tooling)
    implementation(Compose.toolingPreview)
    implementation(Libs.AndroidX.lifeCycleRuntime)

    implementation(Libs.Coroutines.android)

    implementation(Libs.Others.timber)
    implementation(Libs.Others.coil)
    implementation(Libs.Accompanist.navigationAnim)

    implementation(Libs.Hilt.library)
    add("kapt", Libs.Hilt.googleAndroidCompiler)
    add("kapt", Libs.Hilt.googleCompiler)

    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Coroutines.android)

    implementation(Libs.Others.timber)
    implementation(Libs.Others.retrofit)
    implementation(Libs.Others.retrofit_converter_gson)
    implementation(Libs.Others.mockwebserver)

    implementation(Libs.Room.runtime)
    implementation(Libs.Room.ktx)
    add("kapt", Libs.Room.annotationProcessor)

    testImplementation(Tests.junit)
    testImplementation(Tests.junitKotlin)
    testImplementation(Tests.mockk)
    testImplementation(Tests.androidXCoreTest)
    testImplementation(Libs.Room.testing)
}