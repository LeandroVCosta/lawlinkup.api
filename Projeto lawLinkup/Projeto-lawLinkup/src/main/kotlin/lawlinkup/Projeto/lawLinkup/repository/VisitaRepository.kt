package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.domain.Visita
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface VisitaRepository : JpaRepository<Visita, Long>{

    @Query("""
       SELECT DATE_FORMAT(v.dtVisita, '%Y-%m') as mesAno, COUNT(*) as quantidadeTotal FROM Visita v 
        WHERE v.advogado.id = ?1 GROUP BY mesAno ORDER BY mesAno
    """)
    fun findByVisitasMensais(id:Long): List<ListaDadosMensais>
}