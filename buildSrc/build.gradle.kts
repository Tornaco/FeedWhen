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
            implementationClass = "tornaco.project.android.rennixing.RennixingPlugin"
        }
    }
}

object BuildPluginsVersion {
    const val AGP = "7.2.1"
    const val KOTLIN = "1.5.31"
    const val KOTLIN_LANG_VERSION = "1.5"
    const val AAR_2_JAR = "0.6"
    const val KTLINT = "10.2.1"
}

object LibsVersion {
    const val ASM =
        "7.0" // compatibility matrix -> https://developer.android.com/reference/tools/gradle-api/7.1/com/android/build/api/instrumentation/InstrumentationContext#apiversion
}

object Libs {
    val AGP = "com.android.tools.build:gradle:${BuildPluginsVersion.AGP}"

    // bytecode instrumentation
    const val ASM = "org.ow2.asm:asm-util:${LibsVersion.ASM}"
    const val ASM_COMMONS = "org.ow2.asm:asm-commons:${LibsVersion.ASM}"
}

dependencies {
    implementation("org.eclipse.jgit:org.eclipse.jgit:5.10.0.202012080955-r")

    implementation(gradleApi())
    implementation(Libs.AGP)

    implementation(kotlin("gradle-plugin","1.7.0")) // Added.

    implementation(Libs.ASM)
    implementation(Libs.ASM_COMMONS)
}