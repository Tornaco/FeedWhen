package tornaco.project.android.rennixing

import java.util.*

private val props = Properties()

object Configs {
    const val compileSdkVersion = 30
    const val minSdkVersion = 21
    const val targetSdkVersion = 28

    const val versionCode = 1
    const val versionName = "1.0"

    const val appId = "tornaco.project.android.rennixing"


    operator fun get(key: String): String? {
        val v = props[key] as? String ?: return null
        return if (v.isBlank()) null else v
    }
}