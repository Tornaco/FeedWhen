package tornaco.project.android.feedwhen.data.source.remote

data class ServerResponse<T>(var data: T? = null, val code: Int = 0, val msg: String = "") {
    fun isSuccess() = code == 0

    fun toServerErrorException(): ServerErrorException {
        return ServerErrorException(code = code, msg = msg)
    }
}

data class ServerErrorException(val code: Int, val msg: String) : Exception(msg)