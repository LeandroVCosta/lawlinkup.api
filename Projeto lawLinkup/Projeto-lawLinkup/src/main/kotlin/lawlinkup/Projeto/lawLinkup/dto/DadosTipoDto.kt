package lawlinkup.Projeto.lawLinkup.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import lawlinkup.Projeto.lawLinkup.enuns.TipoUsuario

data class DadosTipoDto(

    @field:NotBlank
    var idTipo:Long,

)