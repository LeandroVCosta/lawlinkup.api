package lawlinkup.Projeto.lawLinkup.dtos

import jakarta.validation.constraints.FutureOrPresent
import jakarta.validation.constraints.NotNull
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

data class DadosOrcamentoDto(


        var idOrcamento:Long,

        @field:NotNull
        var vinculoId:Long,


        @field:NotNull
        var valorOrcamento:Double,

        @field:NotNull
        @field:FutureOrPresent
        @field:DateTimeFormat(pattern = "yyyy/mm/dd")
        var prazoFinal:LocalDate

) {
}