package lawlinkup.Projeto.lawLinkup.cliente.vinculo

import com.google.api.client.util.DateTime
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

data class DadosVinculoDto(

    var id:Long,

    @NotBlank
    var advogadoId:Long,

    @NotBlank
    var casoId:Long,

    @NotBlank
    var clienteId:Long,

    var avaliacao:Int,

    var orcarmento:Double,

) {
}