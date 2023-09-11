package lawlinkup.Projeto.lawLinkup.dtos

import java.time.LocalDate

data class ClienteDto(
    var idUsuario: Long,
    var nome: String,
    var senha: String,
    var email: String,
    var contato: String,
    var cep: String,
    var cidade: String,
    var bairro: String,
    var numero: String,
    var profissao: String?, // Campo específico do cliente
    var dataNascimento: LocalDate?, // Campo específico do cliente
    var estadoCivil: String?, // Campo específico do cliente
    var sexo: String?, // Campo específico do cliente
    var numeroOab: String?, // Campo específico do advogado
    var sobre: String?, // Campo específico do advogado
    var especializacao: String?, // Campo específico do advogado
    var tipoUsuarioId: Long
)

