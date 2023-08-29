package lawlinkup.Projeto.lawLinkup.usuario

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import lawlinkup.Projeto.lawLinkup.enuns.TipoUsuario
import lawlinkup.Projeto.lawLinkup.usuario.tipo.Tipo
import java.time.LocalDateTime

data class UsuarioDto(
    @field:NotNull
    var idUsuario:Long,
    var nome:String,
    var senha:String,
    var email:String,
    var contato:String,
    var cep:String,
    var cidade:String,
    var bairro:String,
    var numero:String,
    var numeroOab:String?,
    var sobre:String?,
    var especializacao:String?,
    var tipoUsuarioId:Long
)
