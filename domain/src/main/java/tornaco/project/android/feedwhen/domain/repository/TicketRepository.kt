package tornaco.project.android.feedwhen.domain.repository

import tornaco.project.android.feedwhen.domain.model.Dest
import tornaco.project.android.feedwhen.domain.model.Start
import tornaco.project.android.feedwhen.domain.model.Ticket
import tornaco.project.android.feedwhen.domain.model.TimeRange

interface TicketRepository {
    suspend fun getTickets(start: Start, dest: Dest, range: TimeRange): List<Ticket>
}