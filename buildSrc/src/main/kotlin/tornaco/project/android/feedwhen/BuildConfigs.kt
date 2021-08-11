package tornaco.project.android.feedwhen

import org.eclipse.jgit.internal.storage.file.FileRepository
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.provideDelegate
import java.io.File
import java.util.*

private val props = Properties()
private var commitHash = ""

object Configs {
    const val compileSdkVersion = 30
    const val minSdkVersion = 21
    const val targetSdkVersion = 28

    const val versionCode = 1
    const val versionName = "1.0"

    const val appId = "tornaco.project.android.feedwhen"


    operator fun get(key: String): String? {
        val v = props[key] as? String ?: return null
        return if (v.isBlank()) null else v
    }
}


class FeedWhenPlugin : Plugin<Project> {
    override fun apply(project: Project) = project.applyPlugin()

    private fun Project.applyPlugin() {
        props.clear()
        rootProject.file("gradle.properties").inputStream().use { props.load(it) }
        val configPath: String? by this
        println("FeedWhenPlugin --- configPath:$configPath")
        val config = configPath?.let { File(it) } ?: rootProject.file("local.properties")
        if (config.exists())
            config.inputStream().use { props.load(it) }

        val repo = FileRepository(rootProject.file(".git"))
        val refId = repo.refDatabase.exactRef("HEAD").objectId
        commitHash = repo.newObjectReader().abbreviate(refId, 8).name()
        println("FeedWhenPlugin --- commitHash:$commitHash")
    }
}