package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.usuario.advogado.orcamento.Orcamento
import org.springframework.data.jpa.repository.JpaRepository

interface OrcamentoRepository : JpaRepository<Orcamento, Long> {
}