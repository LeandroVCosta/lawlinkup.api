package lawlinkup.Projeto.lawLinkup.domain.entity

import jakarta.persistence.*
import lawlinkup.Projeto.lawLinkup.domain.Tipo
import lawlinkup.Projeto.lawLinkup.domain.Usuario
import java.time.LocalDate
import java.time.LocalDateTime

class AdvogadoAvaliacao(
    var Usuario:Usuario? = null,
    var avaliacao: Double? = null,
    var qtdAvaliacao: Long? = null
) {

}