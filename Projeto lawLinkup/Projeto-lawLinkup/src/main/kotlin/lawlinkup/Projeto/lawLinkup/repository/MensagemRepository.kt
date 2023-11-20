package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.domain.Mensagem
import org.springframework.data.jpa.repository.JpaRepository

interface MensagemRepository : JpaRepository <Mensagem,Long> {
}