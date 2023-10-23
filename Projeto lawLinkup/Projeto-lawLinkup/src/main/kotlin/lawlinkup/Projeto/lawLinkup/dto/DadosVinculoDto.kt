package lawlinkup.Projeto.lawLinkup.dtos

import com.google.api.client.util.DateTime
import jakarta.validation.constraints.*
import lawlinkup.Projeto.lawLinkup.enuns.TipoUsuario
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import java.time.LocalDateTime

data class DadosVinculoDto(

        var idVinculo:Long,

        @field:NotNull
        var advogadoId:Long,

        @field:NotNull
        var casoId:Long,

        var situacao:String,

        var avaliacao:Int,

        ) {
}