package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.domain.Assinatura
import org.springframework.data.jpa.repository.JpaRepository


interface AssinaturaRepository : JpaRepository<Assinatura, Int> {
}