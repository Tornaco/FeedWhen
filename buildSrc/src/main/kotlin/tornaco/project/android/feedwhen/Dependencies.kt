package tornaco.project.android.feedwhen

object ClassPaths {
    const val gradlePlugin = "com.android.tools.build:gradle:7.0.0"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21"
}

object Compose {
    const val composeVersion = "1.1.0-alpha01"

    const val animation = "androidx.compose.animation:animation:$composeVersion"
    const val iconsExtended = "androidx.compose.material:material-icons-extended:$composeVersion"
    const val material = "androidx.compose.material:material:$composeVersion"
    const val runtime = "androidx.compose.runtime:runtime:$composeVersion"
    const val runtimeSaveAble = "androidx.compose.runtime:runtime-saveable:$composeVersion"
    const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    const val tooling = "androidx.compose.ui:ui-tooling:$composeVersion"
    const val ui = "androidx.compose.ui:ui:$composeVersion"
    const val uiUtil = "androidx.compose.ui:ui-util:$composeVersion"
    const val uiTest = "androidx.compose.ui:ui-test-junit4:$composeVersion"
    const val activityCompose = "androidx.activity:activity-compose:1.3.1"
    const val navigationCompose = "androidx.navigation:navigation-compose:2.4.0-alpha03"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha03"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
}

object Tests {
    private const val junitVersion = "4.13.2"
    private const val junitKtx = "1.1.2"

    const val junit = "junit:junit:$junitVersion"
    const val junitKotlin = "androidx.test.ext:junit-ktx:$junitKtx"
    const val mockk = "io.mockk:mockk:1.12.0"
    const val mockito = "org.mockito:mockito-core:3.3.3"
    const val androidXCoreTest = "androidx.arch.core:core-testing:2.1.0"
}

object Core {
    const val androidXCore = "androidx.core:core-ktx:1.3.2"
    const val appCompat = "androidx.appcompat:appcompat:1.3.1"
    const val material = "com.google.android.material:material:1.4.0"
}

object Libs {

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.0"
    }

    object Coroutines {
        private const val version = "1.5.0-RC"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object Hilt {
        private const val version = "2.37"
        const val library = "com.google.dagger:hilt-android:$version"
        const val googleAndroidCompiler = "com.google.dagger:hilt-android-compiler:$version"
        const val googleCompiler = "com.google.dagger:hilt-compiler:$version"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
    }

    object AndroidX {
        const val lifeCycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    }

    object Room {
        private const val roomVersion = "2.4.0-alpha04"
        const val runtime = "androidx.room:room-runtime:$roomVersion"
        const val annotationProcessor = "androidx.room:room-compiler:$roomVersion"
        const val ktx = "androidx.room:room-ktx:$roomVersion"
        const val testing = "androidx.room:room-testing:$roomVersion"
    }

    object Others {
        const val timber = "com.jakewharton.timber:timber:4.7.1"
        const val coil = "io.coil-kt:coil-compose:1.3.2"
        const val retrofit = "com.squareup.retrofit2:retrofit:2.7.1"
        const val retrofit_converter_gson = "com.squareup.retrofit2:converter-gson:2.7.1"

        // for testing retrofit.
        const val mockwebserver = "com.squareup.okhttp3:mockwebserver:4.9.1"
    }

    object Accompanist {
        private const val version = "0.16.0"
        const val navigationAnim =
            "com.google.accompanist:accompanist-navigation-animation:$version"
    }
}
