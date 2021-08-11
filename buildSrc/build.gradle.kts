import org.gradle.kotlin.dsl.`kotlin-dsl`

repositories {
    mavenCentral()
    google()
}

plugins {
    `kotlin-dsl`
}


gradlePlugin {
    plugins {
        register("FeedWhenPlugin") {
            id = "FeedWhenPlugin"
            implementationClass = "tornaco.project.android.feedwhen.FeedWhenPlugin"
        }
    }
}

dependencies {
    implementation("org.eclipse.jgit:org.eclipse.jgit:5.10.0.202012080955-r")
}