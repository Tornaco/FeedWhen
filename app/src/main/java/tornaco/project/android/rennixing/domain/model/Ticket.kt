package tornaco.project.android.rennixing.domain.model

import java.util.*

data class Ticket(
    val price: Double,
    val takeOffTime: Date,
    val landingTime: Date
)