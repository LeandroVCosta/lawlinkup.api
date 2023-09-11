package lawlinkup.Projeto.lawLinkup.dtos

import java.time.LocalDate

data class AdvogadoDto(
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
    var profissao:String?,
    var dataNascimento: LocalDate?,
    var estadoCivil:String?,
    var sexo:String?,
    var tipoUsuarioId:Long,

)
