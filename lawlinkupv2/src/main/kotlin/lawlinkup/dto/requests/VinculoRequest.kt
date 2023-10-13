package lawlinkup.dto.requests

import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

data class VinculoRequest (
    val idVinculo:Long?,
    val idAdvogado:Long,
    val idCaso:Long,
    val avaliacao:Int,
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    val prazoFinal:LocalDate
)

