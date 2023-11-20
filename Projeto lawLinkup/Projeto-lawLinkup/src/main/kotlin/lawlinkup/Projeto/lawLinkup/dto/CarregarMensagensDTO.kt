package lawlinkup.Projeto.lawLinkup.dto

import lawlinkup.Projeto.lawLinkup.domain.Usuario

data class CarregarMensagensDTO(
    val remetente:Usuario,
    val destinatario:Usuario
)
