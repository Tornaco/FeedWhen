buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(tornaco.project.android.feedwhen.ClassPaths.gradlePlugin)
        classpath(tornaco.project.android.feedwhen.ClassPaths.kotlinPlugin)
        classpath(tornaco.project.android.feedwhen.Libs.Hilt.gradlePlugin)
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