buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(tornaco.project.android.rennixing.ClassPaths.gradlePlugin)
        classpath(tornaco.project.android.rennixing.ClassPaths.kotlinPlugin)
        classpath(tornaco.project.android.rennixing.Libs.Hilt.gradlePlugin)
    }
}

plugins {
    id("com.diffplug.spotless").version("5.7.0")
}

subprojects {
    repositories {
        google()
        mavenCentral()
    }

    apply(plugin = "com.diffplug.spotless")


}

allprojects {
    project.tasks.forEach {
        println("actions ${it}")
    }
}