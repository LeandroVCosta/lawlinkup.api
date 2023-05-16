package lawlinkup.Projeto.lawLinkup.autenticacao

import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.validation.constraints.NotBlank
import lawlinkup.Projeto.lawLinkup.tipo.Tipo

data class DadosUsuarioDto(

    var id:Long,

    @NotBlank
    var email:String,

    @NotBlank
    var senha:String,

    @NotBlank
    var tipo: Tipo,


    var ativo:Boolean
){}
