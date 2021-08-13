package tornaco.project.android.feedwhen.domain.model

import java.util.*

data class Ticket(
    val price: Double,
    val takeOffTime: Date,
    val landingTime: Date
)