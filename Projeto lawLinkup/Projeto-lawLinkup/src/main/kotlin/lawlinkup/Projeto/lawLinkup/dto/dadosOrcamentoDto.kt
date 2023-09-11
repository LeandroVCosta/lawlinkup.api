package lawlinkup.Projeto.lawLinkup.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class dadosOrcamentoDto(

    @field:NotNull
    var idOrcamento:Long,

    @field:NotNull
    var tipoServicoId:Long,

    @field:NotNull
    var vinculoId:Long,

    @field:NotBlank
    var status: Boolean,

    @field:NotBlank
    var valorOrcamento:Double,

    @field:NotBlank
    var detalhamento:String
) {
}