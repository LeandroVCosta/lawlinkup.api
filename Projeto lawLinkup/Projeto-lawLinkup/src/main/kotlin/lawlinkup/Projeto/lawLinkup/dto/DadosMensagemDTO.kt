package lawlinkup.Projeto.lawLinkup.dto

import jakarta.persistence.*
import lawlinkup.Projeto.lawLinkup.domain.Usuario
import lawlinkup.Projeto.lawLinkup.domain.Vinculo

data class DadosMensagemDTO (
    val id:Long?,

    val idVinculo: Long,

    val idRemetente: Long,

    val idDestinatario: Long,

    val mensagem:String
)