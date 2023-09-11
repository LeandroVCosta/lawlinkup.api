package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.domain.Orcamento
import org.springframework.data.jpa.repository.JpaRepository

interface OrcamentoRepository : JpaRepository<Orcamento, Long> {
}