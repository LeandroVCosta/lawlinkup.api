package lawlinkup.Projeto.lawLinkup.dtos

import jakarta.validation.constraints.FutureOrPresent
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

data class AtualizarDadosVinculoDto(

        var id:Long,

        @field:FutureOrPresent
        @field:DateTimeFormat(pattern = "yyyy/mm/dd")
        var prazoFinal:LocalDate?,

        @field:NotNull
        var avaliacao: Int,

        var comentario:String?
){

}
