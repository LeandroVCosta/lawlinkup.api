package lawlinkup.Projeto.lawLinkup.dtos

<<<<<<< Updated upstream:Projeto lawLinkup/Projeto-lawLinkup/src/main/kotlin/lawlinkup/Projeto/lawLinkup/usuario/UsuarioDto.kt
import jakarta.validation.constraints.NotNull
=======
import java.time.LocalDate
>>>>>>> Stashed changes:Projeto lawLinkup/Projeto-lawLinkup/src/main/kotlin/lawlinkup/Projeto/lawLinkup/dtos/UsuarioDto.kt

data class UsuarioDto(
    var idUsuario:Long,
    var nome:String,
    var senha:String,
    var email:String,
    var contato:String,
    var cep:String,
    var cidade:String,
    var bairro:String,
    var numero:String,
<<<<<<< Updated upstream:Projeto lawLinkup/Projeto-lawLinkup/src/main/kotlin/lawlinkup/Projeto/lawLinkup/usuario/UsuarioDto.kt
    var numeroOab:String?,
    var sobre:String?,
    var especializacao:String?,
=======
    var numeroOab:String,
    var sobre:String,
    var especializacao:String,
    var profissao:String,
    var dataNascimento:LocalDate?,
    var estadoCivil:String,
    var sexo:String,
>>>>>>> Stashed changes:Projeto lawLinkup/Projeto-lawLinkup/src/main/kotlin/lawlinkup/Projeto/lawLinkup/dtos/UsuarioDto.kt
    var tipoUsuarioId:Long
)
