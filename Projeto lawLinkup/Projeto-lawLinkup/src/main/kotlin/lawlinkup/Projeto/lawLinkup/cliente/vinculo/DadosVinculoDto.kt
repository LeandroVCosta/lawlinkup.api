package lawlinkup.Projeto.lawLinkup.cliente.vinculo

import com.google.api.client.util.DateTime
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

data class DadosVinculoDto(

    var id:Long,

    var dataCriacao:LocalDateTime,

    @NotBlank
    var advogadoId:Long,

    @NotBlank
    var casoId:Long,


    var avaliacao:Int,

    var orcarmento:Int

) {
}