package lawlinkup.dto.requests

import lawlinkup.domain.Vinculo
import java.time.LocalDateTime

class MensagemRequest (
    val idMensagem: Long?,
    val vinculo: Long,
    val corpoMensagem:String,
    val horario: LocalDateTime,
    val remetente: Long,
    val destinatario: Long
)