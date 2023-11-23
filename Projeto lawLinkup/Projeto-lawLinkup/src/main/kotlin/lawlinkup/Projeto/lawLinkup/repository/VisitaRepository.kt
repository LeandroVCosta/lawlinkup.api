package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.domain.Visita
import org.springframework.data.jpa.repository.JpaRepository

interface VisitaRepository : JpaRepository<Visita, Long> {
}