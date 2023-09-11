package lawlinkup.Projeto.lawLinkup.dtos

import lawlinkup.Projeto.lawLinkup.domain.Assinatura

data class AtualizarAssinaturaDto(

    var id: Int,

    var fkAssinatura: Assinatura
){}
