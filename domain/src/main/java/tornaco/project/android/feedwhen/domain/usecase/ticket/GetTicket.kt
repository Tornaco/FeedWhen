package tornaco.project.android.feedwhen.domain.usecase.ticket

import tornaco.project.android.feedwhen.domain.model.Dest
import tornaco.project.android.feedwhen.domain.model.Start
import tornaco.project.android.feedwhen.domain.model.Ticket
import tornaco.project.android.feedwhen.domain.model.TimeRange
import tornaco.project.android.feedwhen.domain.repository.TicketRepository
import tornaco.project.android.feedwhen.domain.usecase.FlowUseCase
import javax.inject.Inject

class GetTicketUseCase @Inject constructor(private val ticketRepository: TicketRepository) :
    FlowUseCase<GetTickParams, List<Ticket>>() {

    override suspend fun execute(param: GetTickParams): List<Ticket> {
        return ticketRepository.getTickets(param.start, param.dest, param.range)
    }
}

data class GetTickParams(val start: Start, val dest: Dest, val range: TimeRange)