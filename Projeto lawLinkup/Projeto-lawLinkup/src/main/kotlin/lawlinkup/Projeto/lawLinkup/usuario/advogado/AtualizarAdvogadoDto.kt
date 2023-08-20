package lawlinkup.Projeto.lawLinkup.usuario.advogado

import jakarta.validation.constraints.NotBlank

data class AtualizarAdvogadoDto(

    var id:Long,

    @NotBlank
    var nome:String,

    @NotBlank
    var especializacao:String,

    @NotBlank
    var sobre:String,

) {
}