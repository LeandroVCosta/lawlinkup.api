package lawlinkup.Projeto.lawLinkup.usuario.vinculo

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

    @field:NotNull
    var clienteId:Long,

    var avaliacao:Int,

//    var orcarmento:Double,

    var prazoFinal: LocalDate?

) {
}