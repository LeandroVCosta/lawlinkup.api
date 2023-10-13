package lawlinkup.Projeto.lawLinkup.dto

import lawlinkup.Projeto.lawLinkup.enuns.Status

data class DadosRegistroDto(
    var idHistorico:Long,
    var fkVinculo: Long,
    var status:String,
)
