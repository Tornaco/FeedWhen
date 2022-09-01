repositories {
    mavenCentral()
    google()
}

plugins {
    `kotlin-dsl`

    id("java-gradle-plugin")
}


gradlePlugin {
    plugins {
        register("rennixingPlugin") {
            id = "rennixingPlugin"
            implementationClass = "tornaco.project.android.rennixing.rennixingPlugin"
        }
    }
}

object BuildPluginsVersion {
    val AGP = System.getenv("VERSION_AGP") ?: "7.2.1"
    const val DOKKA = "1.5.31"
    const val KOTLIN = "1.5.31"
    const val KOTLIN_LANG_VERSION = "1.5"
    const val AAR_2_JAR = "0.6"
    const val KTLINT = "10.2.1"

    // do not upgrade to 0.18.0, it does not generate the pom-default.xml and module.json under
    // build/publications/maven
    const val MAVEN_PUBLISH = "0.17.0"
    const val PROGUARD = "7.1.0"
}

object LibsVersion {
    const val JUNIT = "4.13.2"
    const val ASM =
        "7.0" // compatibility matrix -> https://developer.android.com/reference/tools/gradle-api/7.1/com/android/build/api/instrumentation/InstrumentationContext#apiversion
    const val SQLITE = "2.1.0"
    const val SENTRY = "5.5.0"
}

object Libs {
    val AGP = "com.android.tools.build:gradle:${BuildPluginsVersion.AGP}"
    const val JUNIT = "junit:junit:${LibsVersion.JUNIT}"
    const val PROGUARD = "com.guardsquare:proguard-gradle:${BuildPluginsVersion.PROGUARD}"

    // bytecode instrumentation
    const val ASM = "org.ow2.asm:asm-util:${LibsVersion.ASM}"
    const val ASM_COMMONS = "org.ow2.asm:asm-commons:${LibsVersion.ASM}"
    const val SQLITE = "androidx.sqlite:sqlite:${LibsVersion.SQLITE}"
    const val SQLITE_FRAMEWORK = "androidx.sqlite:sqlite-framework:${LibsVersion.SQLITE}"
    const val SENTRY_ANDROID = "io.sentry:sentry-android:${LibsVersion.SENTRY}"

    // test
    val MOCKITO_KOTLIN = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0"
}

dependencies {
    implementation("org.eclipse.jgit:org.eclipse.jgit:5.10.0.202012080955-r")

    compileOnly(gradleApi())
    compileOnly(Libs.AGP)
    compileOnly(Libs.PROGUARD)

    compileOnly(Libs.ASM)
    compileOnly(Libs.ASM_COMMONS)
}