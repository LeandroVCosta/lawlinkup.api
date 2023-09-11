package lawlinkup.Projeto.lawLinkup.dtos

import jakarta.validation.constraints.NotBlank

data class DadosCasoDto(
    var idCaso: Long,

    @NotBlank
    var servico: String,

    @NotBlank
    var especificacao: String,

    @NotBlank
    var detalhamento:String,

    var clienteId: Long,



) {
}