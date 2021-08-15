package tornaco.project.android.feedwhen.data.source.remote

import java.io.InputStreamReader

class StubResponseFileReader(path: String) {

    val content: String

    init {
        val reader = InputStreamReader(this.javaClass.classLoader?.getResourceAsStream(path))
        content = reader.readText()
        reader.close()
    }
}