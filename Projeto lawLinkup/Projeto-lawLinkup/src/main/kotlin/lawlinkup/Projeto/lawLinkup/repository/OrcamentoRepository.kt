package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.domain.Orcamento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface OrcamentoRepository : JpaRepository<Orcamento, Long> {


    @Query("""
        SELECT o FROM Orcamento o WHERE vinculo.id = ?1
    """)
    fun getOrcamentoPorVinculo(id:Long):Orcamento
}