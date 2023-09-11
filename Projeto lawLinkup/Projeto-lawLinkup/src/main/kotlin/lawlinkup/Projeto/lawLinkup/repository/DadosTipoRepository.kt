package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.domain.Tipo
import org.springframework.data.jpa.repository.JpaRepository

interface DadosTipoRepository : JpaRepository<Tipo, Long> {
}