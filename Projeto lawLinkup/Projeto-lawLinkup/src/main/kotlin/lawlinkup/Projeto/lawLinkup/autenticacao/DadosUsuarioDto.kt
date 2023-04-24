package lawlinkup.Projeto.lawLinkup.autenticacao

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class DadosUsuarioDto(

    var id:Long,
    @NotBlank
    var login:String,
    @NotBlank(message = "A senha deve contér entre 5 e 10 caracteres")
    var senha:String,
    var ativo:Boolean
){}
