package lawlinkup.Projeto.lawLinkup.dtos

import jakarta.validation.constraints.NotBlank

data class DadosEditarAdvogadoDto(

    var id:Long?,

    @NotBlank
    var nome:String?,

    @NotBlank
    var especializacao:String,

    @NotBlank
    var sobre:String,

) {
}