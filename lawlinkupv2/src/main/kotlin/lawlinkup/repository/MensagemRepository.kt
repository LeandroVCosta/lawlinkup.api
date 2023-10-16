package lawlinkup.repository

import lawlinkup.domain.Mensagem
import org.springframework.data.jpa.repository.JpaRepository

interface MensagemRepository:JpaRepository<Mensagem,Long> {
}