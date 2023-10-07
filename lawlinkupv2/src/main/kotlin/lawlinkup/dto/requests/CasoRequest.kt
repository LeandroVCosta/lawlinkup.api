package lawlinkup.dto.requests

import java.time.LocalDateTime

data class CasoRequest (
    val idCaso:Long?,
    val servico:String,
    val especificacao:String,
    val detalhamento:String,
    val cliente:Long,
    val ativo:Boolean
)
