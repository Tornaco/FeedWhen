buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(tornaco.project.android.feedwhen.ClassPaths.gradlePlugin)
        classpath(tornaco.project.android.feedwhen.ClassPaths.kotlinPlugin)
        classpath(tornaco.project.android.feedwhen.Libs.Hilt.gradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")
    }
}

plugins {
    id("com.diffplug.spotless").version("5.7.0")
    id("FeedWhenPlugin")
}

subprojects {
    repositories {
        google()
        mavenCentral()
    }

    apply(plugin = "com.diffplug.spotless")


}