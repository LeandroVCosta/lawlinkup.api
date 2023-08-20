package lawlinkup.Projeto.lawLinkup.autenticacao

import jakarta.validation.constraints.NotBlank
import lawlinkup.Projeto.lawLinkup.enuns.TipoUsuario

data class DadosLoginDto(

    var id:Long,

    @field:NotBlank
    var email:String,

    @field:NotBlank
    var senha:String,

    var ativo:Boolean = true
){}
