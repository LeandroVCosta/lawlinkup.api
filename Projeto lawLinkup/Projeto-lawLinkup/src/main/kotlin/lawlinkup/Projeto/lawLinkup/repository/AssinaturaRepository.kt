package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.usuario.assinatura.Assinatura
import org.springframework.data.jpa.repository.JpaRepository


interface AssinaturaRepository : JpaRepository<Assinatura, Int> {
}